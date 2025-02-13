#ifndef UTIL_H
#define UTIL_H

typedef char string[128];

typedef struct
{
    string team1;
    string team2;
} Teams;

typedef struct
{
    Teams teams;
    int price;
    int sold_tickets;
    int max_tickets; 
} Match;

typedef struct
{
    int size;
    Match* matches;
} TicketInventory;

void setup(TicketInventory* inventory, int size);
void dispose(TicketInventory *inventory);
void load(TicketInventory *inventory, char *filename)

#endif