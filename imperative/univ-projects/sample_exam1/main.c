#include <stdio.h>
#include "utils.h"


int main()
{
    TicketInventory inventory;

    setup(&inventory,3);

    load(&inventory, "matches.txt");

    print(inventory,ALL);
    
    sell(&inventory, "Juventus", "Barcelona", 10);

    sell(&inventory, "TeamA", "TeamB", 1);

    print(inventory, ALL);

    dump(inventory, "dump.txt");

    dispose(&inventory);
}