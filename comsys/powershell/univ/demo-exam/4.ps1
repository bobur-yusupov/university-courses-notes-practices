<#
Write a Powershell script (4.ps1), which gets a file name as parameter. In the file lines there are names.  Write out the too long names (longer than 20 charcters) into a log.txt file and the others on to the screen!

E.g. The file:
Bakonyi Viktória                             //short, so it will be       => monitor
Illés  Zoltán                                         //short so it will be     => monitor
Kovács Péter Sándor Pál     //too long, it must be in log.txt => log.txt
#>

param(
    $fname
)

$lines = Get-Content $fname

foreach ($line in $lines)
{
    if ($line.Length -gt 20) {
        echo $line >> log.txt
    } else {
        Write-Output $line
    }
}