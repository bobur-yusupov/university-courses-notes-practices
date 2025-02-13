#include <stdio.h>
#include <stdlib.h>

#include "UserManagementSystem.h"

void display_menu() {
    printf("\nUser Management System\n");
    printf("1. Create New User\n");
    printf("2. Modify User\n");
    printf("3. Delete User\n");
    printf("4. Print User Details\n");
    printf("5. Print All Users\n");
    printf("6. Add Group to User\n");
    printf("7. Export User Data to File\n");
    printf("8. Exit\n");
    printf("Enter your choice: ");
}

int main() {
    user_t* root = (user_t*)malloc(sizeof(user_t)); // Initialize the root user

    if (root == NULL) {
        fprintf(stderr, "Memory allocation failed for root user\n");
        return 1;
    }
    
    init(root); // Set up the root user

    int choice;
    int ID, age;
    string name;
    Groups groups[MAXIMUM_GROUPS];
    int group_count;
    char filename[128];

    while (1) {
        display_menu();
        scanf("%d", &choice);

        switch (choice) {
            case 1: // Create New User
                printf("Enter user name: ");
                scanf("%s", name);
                printf("Enter user age: ");
                scanf("%d", &age);
                printf("Enter user ID: ");
                scanf("%d", &ID);
                printf("Enter number of groups for the user (up to %d): ", MAXIMUM_GROUPS);
                scanf("%d", &group_count);
                for (int i = 0; i < group_count; i++) {
                    printf("Enter group %d: (0 = root_user, 201 = system_users, 1001 = operator_users, 2000 = observer_users): ", i + 1);
                    scanf("%d", (int*)&groups[i]);
                }
                create_user(root, name, age, ID, groups, group_count);
                break;

            case 2: // Modify User
                printf("Enter user ID to modify: ");
                scanf("%d", &ID);
                printf("Enter new user name: ");
                scanf("%s", name);
                printf("Enter new user age: ");
                scanf("%d", &age);
                printf("Enter number of groups for the user (up to %d): ", MAXIMUM_GROUPS);
                scanf("%d", &group_count);
                for (int i = 0; i < group_count; i++) {
                    printf("Enter group %d: (0 = root_user, 201 = system_users, 1001 = operator_users, 2000 = observer_users): ", i + 1);
                    scanf("%d", (int*)&groups[i]);
                }
                modify_user(root, ID, name, age, groups, group_count);
                break;

            case 3: // Delete User
                printf("Enter user ID to delete: ");
                scanf("%d", &ID);
                delete_user(&root, ID);
                break;

            case 4: // Print User Details
                printf("Enter user ID to print details: ");
                scanf("%d", &ID);
                print_user(root, ID);
                break;

            case 5: // Print All Users
                print_system(root);
                break;

            case 6: // Add Group to User
                printf("Enter user ID to add group: ");
                scanf("%d", &ID);
                printf("Enter group to add (0 = root_user, 201 = system_users, 1001 = operator_users, 2000 = observer_users): ");
                int group_to_add;
                scanf("%d", &group_to_add);
                add_group(root, ID, (Groups)group_to_add);
                break;

            case 7: // Export User Data to File
                printf("Enter filename to export user data: ");
                scanf("%s", filename);
                export_system(root, filename);
                printf("Data exported successfully to %s\n", filename);
                break;

            case 8: // Exit
                printf("Exiting the program...\n");
                free(root);  // Free memory for root user
                return 0;

            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
}
