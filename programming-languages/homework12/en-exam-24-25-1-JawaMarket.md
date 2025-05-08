# Technical details

You are allowed to submit as many times as you like.

- Recommended: submit each time you solve an exercise part.

Running `check.cmd` will automatically give you a `solution.zip` that you can submit.

- If it doesn't, make sure to choose your root folder as the base folder of the zip.
- If you go one folder higher or one folder too deep, the TMS autotester will certainly reject your solution upon submission.
- Do not add unnecessary stuff (e.g. the Javadoc folder) into the zip.

# Jawa Market

In the following task, you need to implement a droid market operated by a race called Jawa. The market has different sellers (Jawa) who sell droids and parts. Each seller has their own inventory to store their stock. The market allows purchasing, selling, and checking inventory levels.

## Droid Class and Subclasses

### `DroidPart` Class (4 points)
Create the `DroidPart` class to represent droid parts.

The `setDamage` method sets the damage level of the part, ensuring it is between 0 and 100. If the value is invalid, throw an `IllegalArgumentException`.

The `getPrice` method calculates the price of the part based on the damage; the price decreases as the damage increases (maximum price at 0 damage, 0 price at 100 damage).

The `getRepairCost` method returns the repair cost, calculated as the difference between the base price and the damage-adjusted price.

The `upgrade` method increases the base price when the part is upgraded.

### `Droid` Class (8 points)

Implement the `Droid` class as a base class for various droid types. The default energy level of a droid is 100.

The `runDiagnostics` method generates a diagnostic report that includes the status of each part and the droid's energy level.
- Example:
```
Part: DROID_ARM, Damage: 0%
Part: DROID_LEG, Damage: 11%
```

The `charge` method increases the droid's energy level up to  100%.
The `reducePower` method decreases the droid's energy level down to a minimum of 0%.
The textual representation of a `Droid` includes the class name and the result of `runDiagnostics`.
- Example:
```
Droid
Part: DROID_WHEEL, Damage: 0%
Part: DROID_HEAD, Damage: 0%
Part: DROID_TORSO, Damage: 0%
Power Level: 100%
```

The `getParts` method returns a non-copyable instance of the currently available droid parts.

#### Tests (3 points)
Test the `Droid` class with the following methods:

- `testDroidConstructor` tests that the default `powerLevel` is 100.
- `testDroidCharge` to verify that the `charge` method increases the energy level up to a maximum of 100.
- `testDroidReducePower` to verify that the `reducePower` method decreases the energy level down to a minimum of 0.

### `TranslatorDroid` Class (6 points)
Create the `TranslatorDroid` class. A translator droid is able to translate text into different languages.

The `translate` method translates a given text based on the `language` parameter.
- Support "huttese" (each character shifted by 3) and "binary" languages (each character shifted by 1). If an unknown language is provided, return "Unknown language".
- Translating text consumes 5 units of energy. If there is not enough energy, return "Not enough power".
- Helper method: `shiftCharacters`, which shifts each character in a string by a given amount to simulate translation. For example, shifting by 1 turns `'a'` into `'b'`, `'b'` into `'c'`, and so on, without wrapping around. (for `'z'` it should return `'\{')`.

Your task is to override the textual representation of the `Droid` class to include information about the available translation languages.
- Example:
```
TranslatorDroid
Part: DROID_WHEEL, Damage: 0%
Part: DROID_HEAD, Damage: 0%
Part: DROID_TORSO, Damage: 0%
Power Level: 100%
Languages: huttese, binary
```

### `RepairDroid` Class (6 points)
Create the `RepairDroid` class. A repair droid is able to repair droid parts.

The `repairPart` method repairs a part by reducing its `damage` level.
- Each repair consumes exactly 8 units of energy. If there is not enough energy, skip the repair.
The `prioritizeRepair` method repairs parts starting with the most damaged one.

Override the textual representation, so it includes the repair amount in addition to the standard `Droid` description.
- Example:
```
RepairDroid
Part: DROID_WHEEL, Damage: 0%
Part: DROID_HEAD, Damage: 0%
Part: DROID_TORSO, Damage: 0%
Power Level: 100%
Repair amount: 20
```

#### Custom Droid Tests (2 points)
- `testRepairDroidRepair`: Write a parameterized test to verify that the `repairPart` method reduces the part's damage.
  Test cases:
  - Damage = 0
  - Damage = 100
  - Damage equals the exact repair amount.

- `testTranslatorDroidTranslate`: Verify that the `translate` method correctly translates strings.

## Seller Interface and Jawa Class (15 points)

The `addDroidToInventory` method adds a new droid to the inventory.
The `restockPart` method increases the inventory count of a given droid part by the specified amount.
The `checkPartAvailability` method checks if there is sufficient stock of a specific part in the inventory.

The `sellDroid` method calculates and returns the total value of the listed droids, then removes them from the inventory. A droid's value is the sum of its parts' values.
The `sellDroidParts` method calculates and returns the total value of the listed parts, then reduces the inventory stock. If a part is depleted, remove it from the inventory.
- Both methods calculate values **only** for items that are **in stock**.
- Use the `applyDiscount` method to apply a random discount to the total price.

The `applyDiscount` method applies a percentage discount returned by `haggle`. For example, if `haggle` gives a `10%` discount and the original price is `1000`, the discounted price will be `900`.
- The `haggle` method randomly reduces the price by 0%-100% with a 10% probability.

The `browseDroids` method returns a non-copyable instance of the currently available droids. (Make sure to follow proper encapsulation!)
The `browseDroidParts` method returns a non-copyable instance of the available parts and their quantities.

Two `Jawa` objects are equal if and only if their names match.The other method needed for equality check should also use this field.

## Market Class (6 points)

The class contains a list of all current sellers (Jawas).
- The `addSeller` method adds a new `Jawa` to the market.

The following methods check if the specified `Jawa` is part of the market. If not, throw an `IllegalArgumentException` with the message *"The specified seller is not part of this market."*
- The `buyDroids` method allows droid purchases from a specified `Jawa`. This calls the `Jawa`'s `sellDroid` method and returns the total price, also displaying it on the standard output, e.g., *"Droids purchased for a total price of: "*
- The `buyDroidParts` method works similarly but is for part purchases.

- The `displayAvailableDroids` and `displayAvailableParts` methods display the droids and parts available from a specific `Jawa` written to the standard output.
