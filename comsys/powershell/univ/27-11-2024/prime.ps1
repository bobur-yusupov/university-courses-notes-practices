function isPrime($number) {
    $numberOfDivisors = 0

    $i = 2

    while ($i -lt $number)
    {
        if ($number % $i -eq 0) {
            $numberOfDivisors += 1

        }

        $i++
    }

    if ($numberOfDivisors -le 2)
    {
        return $true
    } else {
        return $false
    }
}

isPrime 14