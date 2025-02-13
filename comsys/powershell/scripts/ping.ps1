$servers = Get-Content -Path ".\servers.txt"

Test-Connection -TargetName $servers -Count 1