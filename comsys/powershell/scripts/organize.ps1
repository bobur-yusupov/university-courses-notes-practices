$destination = ".\organized"

if (-not (Test-Path $destination))
{
    New-Item -ItemType Directory -Path $destination
}

$files = Get-ChildItem -Path ".\files"

foreach ($file in $files)
{
    $extension = $file.Extension

    if ($extension -eq ".png" -or $extension -eq ".jpg")
    {
        $newPath = "$destination\Images\"

        if (-not (Test-Path $newPath))
        {
            New-Item -ItemType Directory -Path $newPath
        }

        Move-Item -Path $file.FullName -Destination $newPath
    } if ($extension.ToLower() -eq ".pptx" -or $extension.ToLower() -eq ".txt")
    {
        $newPath = "$destination\Documents\"

        if (-not (Test-Path $newPath))
        {
            New-Item -ItemType Directory -Path $newPath
        }

        Move-Item -Path $file.FullName -Destination $newPath
    }
}