#include <stdio.h>

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
};

typedef enum Day day_t;

int main() {
    day_t today;

    today = WEDNESDAY;

    switch (today) {
        case SUNDAY:
            printf("Today is Sunday.");
            break;
        
        case MONDAY:
            printf("Today is Monday.");
            break;

        case TUESDAY:
            printf("Today is Tuesday.");
            break;

        case WEDNESDAY:
            printf("Today is Wednesday.");
            break;
            
        case THURSDAY:
            printf("Today is Thursday.");
            break;

        case FRIDAY:
            printf("Today is Friday.");
            break;

        case SATURDAY:
            printf("Today is Saturday.");
            break;

        default:
            printf("Invalid day.");
    }

    return 0;
}