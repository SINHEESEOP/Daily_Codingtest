# 📝 Java 파일 패키지 선언 및 클래스명 수정 스크립트
# 🎯 모든 Java 파일의 package 선언을 파일 위치에 맞게 업데이트

# 스크립트 실행 정책 우회
Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process -Force

# src 디렉토리에서 모든 Java 파일 검색
$javaFiles = Get-ChildItem -Path "src" -Filter "*.java" -Recurse

Write-Host "🔍 총 $($javaFiles.Count)개의 Java 파일을 찾았습니다."

foreach ($file in $javaFiles) {
    Write-Host "📝 처리 중: $($file.FullName)"
    
    # 파일 경로 분석
    $relativePath = $file.DirectoryName.Replace((Get-Location).Path + "\src\", "").Replace("\", ".")
    $fileName = $file.BaseName
    
    # 파일 내용 읽기
    $content = Get-Content -Path $file.FullName -Encoding UTF8
    
    # 새로운 패키지 선언
    $newPackage = "package $relativePath;"
    
    # 새로운 클래스명 (파일명과 동일하게)
    $newClassName = $fileName
    
    $modified = $false
    
    # 내용 수정
    for ($i = 0; $i -lt $content.Length; $i++) {
        # 패키지 선언 수정
        if ($content[$i] -match "^package\s+.*;") {
            if ($content[$i] -ne $newPackage) {
                $content[$i] = $newPackage
                $modified = $true
                Write-Host "  📦 패키지 변경: $($content[$i]) → $newPackage"
            }
        }
        
        # public class 선언 수정
        if ($content[$i] -match "^public\s+class\s+(\S+)") {
            $currentClassName = $matches[1]
            if ($currentClassName -ne $newClassName) {
                $content[$i] = $content[$i] -replace "public\s+class\s+\S+", "public class $newClassName"
                $modified = $true
                Write-Host "  🏗️ 클래스명 변경: $currentClassName → $newClassName"
            }
        }
    }
    
    # 수정된 내용이 있으면 파일에 저장
    if ($modified) {
        Set-Content -Path $file.FullName -Value $content -Encoding UTF8
        Write-Host "  ✅ 파일 업데이트 완료"
    } else {
        Write-Host "  ✓ 수정 필요 없음"
    }
}

Write-Host "`n�� 모든 Java 파일 처리 완료!" 