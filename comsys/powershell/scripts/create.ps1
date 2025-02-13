param($name)

$extensions = @("png", "jpg", "txt", "pptx")

foreach ($extension in $extensions)
{
    New-Item -ItemType File -Path ".\files" -Name "$name.$extension"
}