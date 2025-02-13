#include <stdio.h>
#include <stdlib.h>

#include "utils.h"

void setup(TicketInventory *inventory, int size)
{
    inventory->size = size;
    inventory->matches = (Match*)malloc(sizeof(Match) * size);
}

void dispose(TicketInventory *inventory)
{
    free(inventory->matches);
    inventory->size = 0;
}

void load(TicketInventory *inventory, char *filename)
{
    FILE *fp = fopen(filename, "r");

    if (fp == NULL)
    {
        printf("Error opening file\n");

        exit(1);
    }   

    int size = 0;

    while (fscanf(fp, "%s", inventory->matches[size].teams.team1) != EOF)
    {
        fscanf(fp, "%s", inventory->matches[size].teams.team2);
        fscanf(fp, "%s", inventory->matches[size].price);
        fscanf(fp, "%s", inventory->matches[size].sold_tickets);
        fscanf(fp, "%s", inventory->matches[size].max_tickets);
        size++;
    }
}