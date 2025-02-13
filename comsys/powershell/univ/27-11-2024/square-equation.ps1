# a^2x + bx + c = 0
# x1, x2
# read a
 
[int]$a = Read-Host "a"
[int]$b = Read-Host "b"
[int]$c = Read-Host "c"

if ($a -lt 0)
{
    Write-Host "a is less than 0" -ForegroundColor Red
} 

else
{
    $discriminant = $b * $b - 4 * $a * $c

    if ($discriminant -lt 0) {
        Write-Host "there is no solution!"
    } else {
        $x1 = (-1 * $b - [math]::Sqrt($discriminant)) / (2 * $a)
        $x2 = (-1 * $b + [math]::Sqrt($discriminant)) / (2 * $a)

        Write-Host $x1 -ForegroundColor Green
        Write-Host $x2 -ForegroundColor Green
    }
}