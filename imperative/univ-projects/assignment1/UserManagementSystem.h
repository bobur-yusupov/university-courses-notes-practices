#ifndef USER_MANAGEMENT_SYSTEM_H
#define USER_MANAGEMENT_SYSTEM_H

#include <stdio.h>
#include <stdbool.h>

// Define macro MAXIMUM_GROUPS to 4 as maximum number of groups a user can be member of
#define MAXIMUM_GROUPS 4

// Declare a typedef for string, an array of 128 characters
typedef char string[128];

// Declare Groups enum
typedef enum {
    root_user = 0,
    system_users = 201,
    operator_users = 1001,
    observer_users = 2000,
} Groups;

// Forward declaration of user_t struct
typedef struct user_t user_t;

// Declare struct with user_t typedef which represents a user
struct user_t {
    string name;                    // array of characters which hold name of a user, maximum 128 characters
    int age;                        // integer to store user's age
    int ID;                         // integer to store user's ID in the system
    Groups groups[MAXIMUM_GROUPS];  // Array of groups to store user's access membership
    user_t* nextUser;               // A pointer with user_t type as a reference to the next user in the system
    bool canBedeleted;
};

// Function declarations
user_t* init(user_t* new_user);
int count_users(user_t* root);
user_t* create_user(user_t* root, string name, int age, int ID, Groups groups[], int lengthOfGroups);
user_t* modify_user(user_t* root, int ID, string newName, int newAge, Groups newGroups[], int newLengthOfGroups);
int delete_user(user_t** root, int ID);
void print_user(user_t* root, int ID);
void print_system(user_t* root);
void add_group(user_t* root, int ID, Groups group);
void export_system(user_t* root, const char* filename);

#endif