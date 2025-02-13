<#

Write a Powershell script (1.ps1), which gets two numbers from the command line - if there are no parameters, read them from the keyboard.  

Calculate the multiplication, the sum and the square root of the numbers and write them out into a file (out.txt) ! E.g. 4 9 => 28, 13, 2, 3 

#>

if ($args.Count -ge 2) {
    [int]$a = $args[0]
    [int]$b = $args[1]

    $multiplication = $a * $b
    $addition = $a + $b
    $sqrtA = [math]::Sqrt($a)
    $sqrtB = [math]::Sqrt($b)

    echo "Sum: $multiplication" >> result.txt
    echo "Addition: $addition" >> result.txt
    echo "Square root of A: $sqrtA" >> result.txt
    echo "Square root of B: $sqrtB" >> result.txt
} else {
    [int]$a = Read-Host "a"
    [int]$b = Read-Host "b"

    $multiplication = $a * $b
    $addition = $a + $b
    $sqrtA = [math]::Sqrt($a)
    $sqrtB = [math]::Sqrt($b)

    echo "Sum: $multiplication" >> result.txt
    echo "Addition: $addition" >> result.txt
    echo "Square root of A: $sqrtA" >> result.txt
    echo "Square root of B: $sqrtB" >> result.txt
}