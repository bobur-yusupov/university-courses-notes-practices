# 14.11.2024

Display Date

```powershell
Get-Date
```

```powershell
(Get-Date).Month
```

Display all commands of PowerShell

```powershell
gcm
```

Alternative `cd`

```powershell
Set-Location
```

Display current location

```powershell
Get-Location
```

Create new file

```powershell
New-Item
```

Rename a file

```powershell
Rename-Item
```

```powershell
$team = "barcelona"
echo $team
```

## Type casting

```powershell
$d = 5.0004
[int] $d
```

it returns `5` because it is casting type from float to integer.

```powershell
$b = "21"
echo [int] $b + 1
```

it returns `22` because it is casting type and then adding `1`.

`Clear-Variable` vs. `Remove-Variable`
`Clear-Variable` only clears the value of the variable, but `Remove-Variable` removes entirely from memory.
