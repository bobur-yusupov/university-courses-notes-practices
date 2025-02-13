#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#include "utils.h"

void setup(TicketInventory *inventory, int size)
{
    Match *matches = (Match*)malloc(size * sizeof(Match));

    inventory->match = matches;
    inventory->size = size;
}

void dispose(TicketInventory *inventory)
{
    free(inventory->match);
    inventory->size = 0;
}

void load(TicketInventory *inventory, const char* filename)
{
    FILE *file = fopen(filename, "r");

    if (!file)
    {
        perror("Error opening the file.");
        exit(EXIT_FAILURE);
    }

    int size = 0;

    while (fscanf(file, "%127s %127s %d %d %d",
        inventory->match[size].teams.team1,
        inventory->match[size].teams.team2,
        &inventory->match[size].price,
        &inventory->match[size].sold_tickets,
        &inventory->match[size].max_tickets) == 5) 
    {
        size++;
    }


    fclose(file);

}

bool sell(TicketInventory *inventory, char *team1, char *team2, int quantity)
{
    for (int i = 0; i < inventory->size; i++)
    {
        if (strcmp(team1, inventory->match[i].teams.team1) == 0 && strcmp(team2, inventory->match[i].teams.team2) == 0)
        {
            int availableTickets = inventory->match[i].max_tickets - inventory->match[i].sold_tickets;

            if (availableTickets >= quantity)
            {
                inventory->match[i].sold_tickets += quantity;

                return true;
            }

            printf("No available tickets!\n");

            return false;
        }
    }

    printf("Teams NOT found!\n");

    return false;
}

void print(TicketInventory inventory, Kind kind)
{
    switch (kind)
    {
    case (AVAILABLE):
        printAllAvailable;
        break;

    case (CHEAPEST):
        printCheapest;
        break;
    
    case (SOLD_OUT):
        printAllSoldout;
    
    default:
        for (size_t i = 0; i < inventory.size; i++)
        {
            printf("Team 1: %s, Team2: %s, price: %d, sold: %d, Max: %d", inventory.match[i].teams.team1, 
                inventory.match[i].teams.team2, 
                inventory.match[i].price, 
                inventory.match[i].sold_tickets, 
                inventory.match[i].max_tickets);
        }
        break;
    }
}

void printCheapest(TicketInventory inventory)
{
    int minPrice = inventory.match[0].price;
    Match cheapestMatch = inventory.match[0];

    for (size_t i = 1; i < inventory.size; i++)
    {
        if (minPrice > inventory.match[i].price)
        {
            minPrice = inventory.match[i].price;
            cheapestMatch = inventory.match[i];
        }
    }

    printf("Cheapest ticket\n %s %s %d", cheapestMatch.teams.team1, cheapestMatch.teams.team2, cheapestMatch.price);
}

void printAllAvailable(TicketInventory inventory)
{
    printf("Available\n");

    for (size_t i = 0; i < inventory.size; i++)
    {
        int available = inventory.match[i].max_tickets - inventory.match[i].sold_tickets;

        if (available > 0)
        {
            printf("Team 1: %s, Team2: %s, price: %d, sold: %d, Max: %d", inventory.match[i].teams.team1, 
                inventory.match[i].teams.team2, 
                inventory.match[i].price, 
                inventory.match[i].sold_tickets, 
                inventory.match[i].max_tickets);
        }
    }
}

void printAllSoldout(TicketInventory inventory)
{
    printf("Sold out:\n");

    for (size_t i = 0; i < inventory.size; i++)
    {
        int sold = inventory.match[i].max_tickets - inventory.match[i].sold_tickets;

        if (sold == 0)
        {
            printf("Team 1: %s, Team2: %s, price: %d, sold: %d, Max: %d", inventory.match[i].teams.team1, 
                inventory.match[i].teams.team2, 
                inventory.match[i].price, 
                inventory.match[i].sold_tickets, 
                inventory.match[i].max_tickets);
        }
    }
}

void dump(TicketInventory inventory, char *filename)
{
    FILE *fp = fopen(filename, "w");

    if (fp == NULL)
    {
        printf("Error opening file!\n");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < inventory.size; i++)
    {
        fprintf(fp, "%s %s %d %d %d\n", inventory.match[i].teams.team1,
            inventory.match[i].teams.team2,
            inventory.match[i].price,
            inventory.match[i].sold_tickets,
            inventory.match[i].max_tickets);
    }

    fclose(fp);
}