$systemInfo = Get-ComputerInfo

$htmlContent = @"
<html>
<head>
    <title>System Information</title>
</head>
<body>
    <h1>System Information</h1>
    <p>OS Version: $($systemInfo.OsVersion)</p>
    <p>Computer Name: $($systemInfo.CsName)</p>
    <p>Processors: $($systemInfo.CsProcessors)</p>
    <p>Total Physical Memory: $($systemInfo.CsTotalPhysicalMemory)</p>
</body>
</html>
"@

$outputPath = "C:\Users\User\Desktop\system-info.html"
$htmlContent | Out-File -FilePath $outputPath -Encoding utf8

Write-Host "System information saved to $outputPath"
