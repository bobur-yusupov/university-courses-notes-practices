#ifndef UTILS_H
#define UTILS_H

#include <stdbool.h>

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
    Match *match;
    int size;
} TicketInventory;

typedef enum
{
    CHEAPEST = 1,
    AVAILABLE = 11,
    SOLD_OUT = 101,
    ALL = 1001,
} Kind;

void setup(TicketInventory *inventory, int size);

void dispose(TicketInventory *inventory);

void load(TicketInventory *inventory, const char* filename);

bool sell(TicketInventory *inventory, char *team1, char *team2, int quantity);

void print(TicketInventory inventory, Kind kind);

void printCheapest(TicketInventory inventory);

void printAllAvailable(TicketInventory inventory);

void printAllSoldout(TicketInventory inventory);

void dump(TicketInventory inventory, char *filename);

#endif