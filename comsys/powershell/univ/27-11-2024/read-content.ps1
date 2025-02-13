param($fname)

if (Test-Path $fname) {


$names=Get-Content $fname

foreach ($d in $names)
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
}
else
{
    echo "Not existing"
}