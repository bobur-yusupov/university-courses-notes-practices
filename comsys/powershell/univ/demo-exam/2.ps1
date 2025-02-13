<#
Write a Powershell script (2.ps1), which gets a number and a word from the command line. Write out the word as many times as it is given by the parameter! The script should work as a filter too! E.g. computer 5 => computer, computer,computer,computer,computer

.SYNOPSIS
This script writes out a word as many times as it is given by the parameter.
#>

param(
    [int]$number,
    [string]$word
)

$i = 0

while ($i -lt $number) {
    Write-Output $word
    $i++
}
