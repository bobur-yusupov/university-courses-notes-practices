$s=0

foreach ($number in $input) # Input is used to get user input from pipe
{
    $s += $number # Differently from shell we dont need to use expr
}

Write-Output $s
echo $a
Write-Host $s
$s