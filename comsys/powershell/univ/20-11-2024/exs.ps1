New-Item -ItemType Directory eng21120 # New directory

Set-Location .\eng21120 # Change current location

New-Item -ItemType File newfile.txt # New file

Get-ChildItem

Copy-Item .\fruit.txt cp1.txt

Copy-Item -Destination cp2.txt -Path .\fruit.txt

# Copy a file

Remove-Item cp?.*

Get-ChildItem | Where-Object { $_.Extension -eq ".txt" }

Get-Content .\fruit.txt | Select-String "^a" # Filter lines which starts with "a"
Get-Content .\fruit.txt | Select-String "a" # Filter lines which contains "a"

Get-ChildItem | Select-Object -Last 1 # Prints out data of last file

Get-ChildItem | Select-Object -Property name, length # It shows only name and length properties of current directory children

Get-ChildItem | Select-Object -Property name, length | Get-Member 
<#
   TypeName: Selected.System.IO.FileInfo

Name        MemberType   Definition
----        ----------   ----------
Equals      Method       bool Equals(System.Object obj)
GetHashCode Method       int GetHashCode()
GetType     Method       type GetType()
ToString    Method       string ToString()
Length      NoteProperty long Length=156
Name        NoteProperty string Name=ex1.ps1 
#>

Get-Content .\fruit.txt | Measure-Object -Line -Word -Character
<#
Lines Words Characters Property
----- ----- ---------- --------
    3     3         19 
#>

# param($x,$y)
# Write-Output hello $x $y

Write-Output hello $args
