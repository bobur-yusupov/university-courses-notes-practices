#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <errno.h>

#include "UserManagementSystem.h"

user_t* init(user_t* new_user) {

    snprintf(new_user->name, sizeof(new_user->name), "root"); 
    new_user->age = 33;
    new_user->ID = 0;
    new_user->groups[0] = root_user;
    new_user->groups[1] = system_users;
    new_user->groups[2] = operator_users;
    new_user->groups[3] = observer_users;
    new_user->nextUser = NULL;
    new_user->canBedeleted = false; // Setting can be deleted to false as ensuring not to be deleted


    return new_user;
}

// Used recursion technique to traverse in the linked list of users
int count_users(user_t* root) {
    if (root == NULL) {
        return 0;
    }

    return 1 + count_users(root->nextUser);
}

void print_user(user_t* root, int ID) {
    while (root != NULL) {
        if (root->ID == ID) {
            printf("Name: %s\n", root->name);
            printf("Age: %d\n", root->age);
            printf("ID: %d\n", root->ID);

            printf("Groups: ");
            bool first_group = true;
            for (int i = 0; i < MAXIMUM_GROUPS; i++) {
                if (root->groups[i] != -1) {
                    if (!first_group) {
                        printf(", ");
                    }
                    // Print group name based on its enum value
                    switch (root->groups[i]) {
                        case root_user:
                            printf("root_user");
                            break;
                        case system_users:
                            printf("system_users");
                            break;
                        case operator_users:
                            printf("operator_users");
                            break;
                        case observer_users:
                            printf("observer_users");
                            break;
                        default:
                            printf("Unknown Group");
                            break;
                    }
                    first_group = false;
                }
            }

            if (root->canBedeleted) {
                printf("\nThis user can be deleted.\n");
            } else {
                printf("\nThis user cannot be deleted.\n");
            }

            return;
        }

        root = root->nextUser;
    }

    printf("Error: User with ID %d not found.\n", ID);
}

user_t* create_user(user_t* root, string name, int age, int ID, Groups groups[], int lengthOfGroups) {
    if (root->nextUser != NULL) {
        return create_user(root->nextUser, name, age, ID, groups, lengthOfGroups);
    }

    for (int i = 0; i < lengthOfGroups; i++) {
        if (groups[i] == root_user) {
            printf("Error: A user cannot be assigned to the root_user group.\n");
            return NULL;
        }
    }

    user_t* new_user = (user_t*)malloc(sizeof(user_t)); // Allocate a new memory in heap

    snprintf(new_user->name, sizeof(new_user->name), "%s", name);
    new_user->age = age;
    new_user->ID = ID;

    for (int i = 0; i < lengthOfGroups; i++) {
        new_user->groups[i] = groups[i];
    }

    new_user->canBedeleted = true;
    new_user->nextUser = NULL;

    root->nextUser = new_user;

    return new_user;
}

user_t* modify_user(user_t* root, int ID, string newName, int newAge, Groups newGroups[], int newLengthOfGroups) {
    while (root != NULL) {
        if (root->ID == ID) {
            snprintf(root->name, sizeof(root->name), "%s", newName);
            root->age = newAge;

            int length = (newLengthOfGroups < sizeof(root->groups) / sizeof(Groups)) ? newLengthOfGroups : sizeof(root->groups) / sizeof(Groups);

            for (int i = 0; i < length; i++) {
                if (newGroups[i] != root_user) {
                    root->groups[i] = newGroups[i];
                }
            }

            printf("User updated successfully!\n");
            return NULL;
        }

        root = root->nextUser;
    }

    printf("Error: User with ID %d not found.\n", ID);
}

int delete_user(user_t** root, int ID) {
    user_t* current = *root;
    user_t* previous = NULL;

    while (current != NULL) {
        if (current->ID == ID) {
            if (previous == NULL) {
                *root = current->nextUser;
            } else {
                previous->nextUser = current->nextUser; 
            }

            free(current);

            printf("User with ID %d deleted successfully.\n", ID);
            return 1;
        }

        previous = current;
        current = current->nextUser;
    }

    // If no user with the given ID is found
    printf("Error: User with ID %d not found.\n", ID);
    return 0;  // Return failure
}


void add_group(user_t* root, int ID, Groups group) {
    user_t* current = root;

    while (current != NULL) {
        if (current->ID == ID) {
            int group_count = 0;
            for (int i = 0; i < MAXIMUM_GROUPS; i++) {
                if (current->groups[i] != -1) {
                    group_count++;
                }
            }

            if (group_count >= MAXIMUM_GROUPS) {
                fprintf(stderr, "Error: User with ID %d already has the maximum number of groups (4).\n", ID);
                return;
            }

            for (int i = 0; i < MAXIMUM_GROUPS; i++) {
                if (current->groups[i] == -1) {
                    current->groups[i] = group;
                    printf("Group %d added to user %s (ID: %d).\n", group, current->name, current->ID);
                    return;
                }
            }
        }

        current = current->nextUser;
    }

    // If no user with the given ID was found
    printf("Error: User with ID %d not found.\n", ID);
}

void print_system(user_t* root) {
    user_t* current = root;

    while (current != NULL) {
        printf("Name: %s\n", current->name);
        printf("Age: %d\n", current->age);
        printf("ID: %d\n", current->ID);

        printf("Groups: ");

        bool first_group = true;
        for (int i = 0; i < MAXIMUM_GROUPS; i++) {
            if (current->groups[i] != -1) {
                if (!first_group) {
                    printf(", ");
                }
                // Print group name based on its enum value
                switch (current->groups[i]) {
                    case root_user:
                        printf("root_user");
                        break;
                    case system_users:
                        printf("system_users");
                        break;
                    case operator_users:
                        printf("operator_users");
                        break;
                    case observer_users:
                        printf("observer_users");
                        break;
                    default:
                        printf("Unknown Group");
                        break;
                }
                first_group = false;
            }
        }

        if (current->canBedeleted) {
            printf("\nThis user can be deleted.\n");
        } else {
            printf("\nThis user cannot be deleted.\n");
        }

        printf("\n");

        current = current->nextUser;
    }
}

void export_system(user_t* root, const char* filename) {
    FILE* file = fopen(filename, "w");  // Open the file for writing

    if (file == NULL) {
        fprintf(stderr, "Error: Could not open file %s for writing.\n", filename);
        return;
    }

    // Write header
    fprintf(file, "User ID   User Name       Age   Groups\n");

    // Traverse the linked list of users
    user_t* current = root;
    while (current != NULL) {
        // Write the user details to the file
        fprintf(file, "%-9d %-15s %-4d [", current->ID, current->name, current->age);

        // Write the groups the user belongs to
        bool first_group = true;
        for (int i = 0; i < MAXIMUM_GROUPS; i++) {
            if (current->groups[i] != -1) {  // Assuming -1 indicates an empty slot in the groups array
                if (!first_group) {
                    fprintf(file, ", ");
                }
                // Print group name based on its enum value
                switch (current->groups[i]) {
                    case root_user:
                        fprintf(file, "root_user");
                        break;
                    case system_users:
                        fprintf(file, "system_users");
                        break;
                    case operator_users:
                        fprintf(file, "operator_users");
                        break;
                    case observer_users:
                        fprintf(file, "observer_users");
                        break;
                    default:
                        fprintf(file, "Unknown Group");
                        break;
                }
                first_group = false;
            }
        }

        fprintf(file, "]\n");

        current = current->nextUser;
    }

    fclose(file);  // Close the file after writing
    printf("System data successfully exported to %s.\n", filename);
}
