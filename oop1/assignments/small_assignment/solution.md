# UML Diagrams for OOP Project

## Class Diagram

A class diagram represents the static structure of a system by showing its classes, attributes, operations, and the relationships among objects.

```plaintext
+--------------------------------+
|          ParkingSpot           |
+--------------------------------+
| - spotNumber: int              |
| - sizeLimit: String            |
| - isAvailable: boolean         |
+--------------------------------+
| + getSpotNumber(): int         |
| + getSizeLimit(): String       |
| + isAvailable(): boolean       |
| + setSpotNumber(int): void     |
| + setSizeLimit(String): void   |
| + setAvailable(boolean): void  |
+--------------------------------+
          |
          |
          V
+-----------------+
|    Student      |
+-----------------+
| - studentId: int|
+-----------------+
| + getStudentId(): int |
+-----------------+
```

## Sequence Diagram

A sequence diagram shows how objects interact in a particular scenario of a use case.

```
+---------+      +---------+      +---------+
|  User   |      |  System |      | Database|
+---------+      +---------+      +---------+
     |                |                |
     |    Login       |                |
     |--------------->|                |
     |                | Validate User  |
     |                |--------------->|
     |                |                |
     |                |  User Valid    |
     |                |<---------------|
     |   Access       |                |
     |<---------------|                |
```

## Use Case Diagram

A use case diagram represents the functionality of a system using actors and use cases.

```plaintext
+-------------------+
|      User         |
+-------------------+
          |
          |
          V
+-------------------+
|  Login            |
+-------------------+
          |
          |
          V
+-------------------+
|  Access Dashboard |
+-------------------+
```

These diagrams provide a visual representation of the system's structure and behavior, making it easier to understand and communicate the design.

## Comprehensive UML Diagram for Parking Lot Management System

### Class Diagram

```plaintext
+--------------------------------+
|          ParkingSpot           |
+--------------------------------+
| - spotNumber: int              |
| - sizeLimit: String            |
| - isAvailable: boolean         |
| - hourlyRate: float            |
+--------------------------------+
| + getSpotNumber(): int         |
| + getSizeLimit(): String       |
| + isAvailable(): boolean       |
| + getHourlyRate(): float       |
| + setSpotNumber(int): void     |
| + setSizeLimit(String): void   |
| + setAvailable(boolean): void  |
| + setHourlyRate(float): void   |
+--------------------------------+

+--------------------------------+
|          ParkingLot            |
+--------------------------------+
| - spots: List<ParkingSpot>     |
| - reservations: List<Reservation> |
+--------------------------------+
| + searchAvailableSpots(size: String, maxPrice: float): List<ParkingSpot> |
| + calculateTotalRevenue(): float |
| + monitorOccupancyRates(): float |
+--------------------------------+

+--------------------------------+
|          Reservation           |
+--------------------------------+
| - spot: ParkingSpot            |
| - startTime: DateTime          |
| - endTime: DateTime            |
| - isLongTerm: boolean          |
+--------------------------------+
| + calculateFee(): float        |
| + applyDiscount(): void        |
| + applyOverstayPenalty(): void |
+--------------------------------+
```

### Sequence Diagram

```plaintext
+---------+      +---------+      +---------+
|  Driver |      |  System |      | Database|
+---------+      +---------+      +---------+
     |                |                |
     |  Search Spot   |                |
     |--------------->|                |
     |                | Query Spots    |
     |                |--------------->|
     |                |                |
     |                | Return Spots   |
     |                |<---------------|
     |  Select Spot   |                |
     |--------------->|                |
     |                | Reserve Spot   |
     |                |--------------->|
     |                |                |
     |                | Confirm Reservation |
     |<---------------|                |
```

### Use Case Diagram

```plaintext
+-------------------+
|      Driver       |
+-------------------+
          |
          |
          V
+-------------------+
|  Search Spot      |
+-------------------+
          |
          |
          V
+-------------------+
|  Reserve Spot     |
+-------------------+
          |
          |
          V
+-------------------+
|  Pay Fee          |
+-------------------+
```

These diagrams provide a detailed visual representation of the parking lot management system, including its structure and interactions.

## Pseudocode for Method Implementations

### ParkingSpot Methods

#### getSpotNumber()

```
function getSpotNumber():
    return spotNumber
```

#### getSizeLimit()

```
function getSizeLimit():
    return sizeLimit
```

#### isAvailable()

```
function isAvailable():
    return isAvailable
```

#### getHourlyRate()

```
function getHourlyRate():
    return hourlyRate
```

#### setSpotNumber(int)

```
function setSpotNumber(newSpotNumber):
    spotNumber = newSpotNumber
```

#### setSizeLimit(String)

```
function setSizeLimit(newSizeLimit):
    sizeLimit = newSizeLimit
```

#### setAvailable(boolean)

```
function setAvailable(newAvailability):
    isAvailable = newAvailability
```

#### setHourlyRate(float)

```
function setHourlyRate(newHourlyRate):
    hourlyRate = newHourlyRate
```

### ParkingLot Methods

#### searchAvailableSpots(size: String, maxPrice: float)

```
function searchAvailableSpots(size, maxPrice):
    availableSpots = []
    for spot in spots:
        if spot.getSizeLimit() == size and spot.isAvailable() and spot.getHourlyRate() <= maxPrice:
            availableSpots.append(spot)
    return availableSpots
```

#### calculateTotalRevenue()

```
function calculateTotalRevenue():
    totalRevenue = 0
    for reservation in reservations:
        totalRevenue += reservation.calculateFee()
    return totalRevenue
```

#### monitorOccupancyRates()

```
function monitorOccupancyRates():
    occupiedSpots = 0
    for spot in spots:
        if not spot.isAvailable():
            occupiedSpots += 1
    return (occupiedSpots / len(spots)) * 100
```

### Reservation Methods

#### calculateFee()

```
function calculateFee():
    duration = endTime - startTime
    fee = duration * spot.getHourlyRate()
    if isLongTerm and duration > 10 * 24:
        extraHours = duration - 10 * 24
        fee += extraHours * spot.getHourlyRate() * 0.5
    return fee
```

#### applyDiscount()

```
function applyDiscount():
    if isLongTerm:
        duration = endTime - startTime
        if duration > 10 * 24:
            extraHours = duration - 10 * 24
            discount = extraHours * spot.getHourlyRate() * 0.5
            return discount
    return 0
```

#### applyOverstayPenalty()

```
function applyOverstayPenalty():
    currentTime = getCurrentTime()
    if currentTime > endTime:
        overstayDuration = currentTime - endTime
        penalty = overstayDuration * spot.getHourlyRate() * 2
        return penalty
    return 0
```
