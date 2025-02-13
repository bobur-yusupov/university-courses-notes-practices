foreach ($d in $args)
{
    if (Test-Path $d) 
    {
        Write-Host "$d is already exist" -ForegroundColor Red
    }
    
    else
    {
        New-Item -ItemType Directory $d
        Copy-Item read.md $d/
    }
}
