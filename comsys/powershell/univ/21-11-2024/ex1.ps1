<#
Synopsis
Write a PowerShell script that lists all the files in a given directory and outputs the names of files that are larger than 1MB.
#>

Get-ChildItem | Where-Object {$_.Length -gt 1MB} | Select-Object -Property Name, length