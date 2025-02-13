$username = Read-Host "Enter the username"

try {
    $user = Get-LocalUser -Name $username
    Write-Host $user.Name
    if ($user.Enabled)
    {
        Write-Host "User $username is enabled" -ForegroundColor Green
    }
    else
    {
        Write-Host "User $username is disabled" -ForegroundColor Yellow
    }

} catch {
    Write-Host "User $username not found" -ForegroundColor Red
    return
}