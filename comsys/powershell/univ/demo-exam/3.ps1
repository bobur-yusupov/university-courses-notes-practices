<#
Write a Powershell script (3.ps1), which gets a file name as parameter. Check the existance of the file! In the file there are  neptun codes (six character long) one per line. Create for each neptun code a directory.

e.g the file is:
A3BCD2
BJD5T7
T45Z67

Therefore the result should be 3 directories named  A3BCD2, BJD5T7 and T45Z67
#>

param(
    $fname
)


if (Test-Path $fname) {
    $neptuns = Get-Content $fname
    
    foreach ($neptun in $neptuns) {
        if (Test-Path $neptun) {
            Write-Host "$neptun is already exist" -ForegroundColor Red
        } else {
            New-Item -ItemType Directory $neptun
        }
    }
}