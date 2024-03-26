import java.util.ArrayList;
import java.util.Scanner;
/*
:::GreenScale:::
- Grönsaksvågen!
Labb 2, ITHS
Sorella Tavares
Javautvecklare, 2023
sorella.tavares@iths.se
*/
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<Product> shoppingCartList = new ArrayList<>();

    public static void main(String[] args) {
        String userInput = "";
        System.out.println("\n      .:GreenScale:.");
        System.out.println("-För butikens frukt och grönt-\n");
        System.out.print("Logga in som medarbetare -> tryck 1\n" +
                "Fortsätt som kund -> tryck 2\n> ");
        String wannaLogin = input.nextLine();
        if (wannaLogin.equals("1")) {
            login();
        } else {
            System.out.println("\nFORTSÄTTER SOM KUND");
            customerMenu();
        }
        do {
            try {
                System.out.print("\nDITT VAL: ");
                userInput = input.nextLine();
                switch (userInput) {
                    case "0" -> System.out.println();
                    case "1" -> customerMenu();
                    case "11" -> adminMenu();
                    case "2" -> textSearch();
                    case "3" -> typeSearch();
                    case "4" -> allProducts();
                    case "5" -> addProduct();
                    case "6" -> removeProduct();
                    case "7" -> login();
                    case "71" -> logout();
                    case "8" -> shoppingCart();
                    default -> System.out.println("Ditt val kunde inte läsas in. Vänligen försök igen.");
                }
            } catch (Exception e) {
                System.out.println("Ditt val kunde inte läsas in. Vänligen försök igen.");
                input.nextLine();
            }
        } while (!userInput.equals("0"));
        System.out.println("Programmet avslutas. Tack för att du använde GreenScale!");
    }
    private static void shoppingCart() {
        // Här skulle jag gärna haft ett enhetstest.
        String searchWhat;
            System.out.print("Vilken vara skulle du vilja lägga till i varukorgen?\n" +
                    "Tryck x för att avsluta och göra ett nytt val.\n> ");
            searchWhat = input.nextLine();
                for (Product product : productList) {
                    if (product.getName().equals(searchWhat)) {
                        System.out.println(product);
                        shoppingCartList.add(product);
                        System.out.println("\nDin varukorg innehåller nu:\n" + shoppingCartList);
                        System.out.println("***********************");
                        System.out.println("Totalt antal varor: " + shoppingCartList.size());
                        double summa = 0;
                        for (Product cartProduct : shoppingCartList) {
                            summa += cartProduct.getPrice();
                        }
                        System.out.println("Totalpris: " + summa);
                        System.out.println("\nTryck 8 för att söka och lägga ytterligare varor i din kundkorg.");
                    }
                }
    }
    private static void login() {
        // Tillfälliga användarnamn och lösenord.
        // Här skulle jag gärna haft ett enhetstest.
        String userId1 = "Användare1";
        String userPassword1 = "Lösenord1";
        String userId2 = "Användare2";
        String userPassword2 = "Lösenord2";
        String userId3 = "Användare3";
        String userPassword3 = "Lösenord3";
        System.out.println("\nLOGGA IN SOM MEDARBETARE");
        System.out.print("Ange ditt användarnamn > ");
        String userId = input.nextLine();
        System.out.print("Ange ditt lösenord > ");
        String userPassword = input.nextLine();
        if (userId.equals(userId1) && userPassword.equals(userPassword1) || userId.equals(userId2) && userPassword.equals(userPassword2) || userId.equals(userId3) && userPassword.equals(userPassword3)) {
            System.out.println("Välkommen! Du är nu INLOGGAD SOM MEDARBETARE\n");
            adminMenu();
        } else {
            System.out.println("Uppgifterna stämde inte.");
            logout();
        }
    }
    private static void logout(){
        System.out.print("Vill du\n1. Logga in igen med andra uppgifter\n2. Fortsätta som kund\n> ");
        String tryAgainToLogOn = input.nextLine();
        if (tryAgainToLogOn.equals("1")) {
            login();
        } else {
            System.out.println("\nDU FORTSÄTTER NU SOM KUND");
            customerMenu();
        }
    }
    private static void adminMenu() {
        System.out.println("\nINLOGGAD SOM MEDARBETARE\n-Meny-\nVälj ett alternativ:\n" +
                "0. Avsluta programmet.\n" +
                "11. Tillbaka till menyn.\n" +
                "2. Sök produkt via text.\n" +
                "3. Sök produkt via varugrupp.\n" +
                "4. Visa samtliga produkter.\n" +
                "5. Lägg till produkt.\n" +
                "6. Ta bort produkt.\n" +
                "7. Logga in som medarbetare.\n" +
                "71. Byt användare eller ändra till kundvy.\n" +
                "8. Lägg till varor i din varukorg.\n");
        System.out.println("Slå in siffran för ditt önskemål, bokstavera ej.");
    }
    private static void customerMenu() {
        System.out.println("KUNDVY\n-Meny-\nVälj ett alternativ:\n" +
                "0. Avsluta programmet.\n" +
                "1. Tillbaka till menyn.\n" +
                "2. Sök produkt via text.\n" +
                "3. Sök produkt via varugrupp.\n" +
                "4. Visa samtliga produkter.\n" +
                "7. Logga in som medarbetare.\n" +
                "8. Lägg till varor i din varukorg.");
        System.out.println("Slå in siffran för ditt önskemål, bokstavera ej.");
    }
    private static void textSearch() {
        // Här skulle jag gärna haft ett enhetstest.
        System.out.print("Sök via text.\nVad söker du? > ");
        String searchThroughText = input.nextLine();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(searchThroughText.toLowerCase())) {
                System.out.print(searchThroughText.toUpperCase());
                System.out.println("hittades:");
                System.out.println(product);
            }
        } if (productList.isEmpty()) {
            System.out.println("Det finns inga produkter inlagda.");
        } else {
            System.out.println("Sökning klar.");
        }
    }
    private static void typeSearch() {
        // Här skulle jag gärna haft ett enhetstest.
        System.out.print("Sök via varugrupp.\nVad söker du? > ");
        String searchThroughProductGroup = input.nextLine();
        for (Product product : productList) {
            if (product.getProductGroup().toLowerCase().contains(searchThroughProductGroup.toLowerCase())) {
                System.out.println(searchThroughProductGroup.toUpperCase());
                System.out.println("hittades:");
                System.out.println(product);
            }
        }
        if (productList.isEmpty()) {
            System.out.println("Det finns inga produkter inlagda.");
        } else {
            System.out.println("Sökning klar.");
            }
    }
    private static void addProduct() {
        // Här skulle jag gärna haft ett enhetstest.
        System.out.println("Lägg till en produkt genom att fylla i kommande fält.");
        System.out.print("Ange sort: ");
        String name = input.nextLine();
        System.out.print("Ange produktgrupp: ");
        String productGroup = input.nextLine();
        System.out.print("Ange ordinarie pris per enhet i formatet 00,00: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.print("Tryck 1 för att ange specialerbjudande (eller enter för att inte lägga till): ");
        String addOffer = input.nextLine();
        double offer = 0.0;
        if (addOffer.equals("1")) {
            // Här skulle jag gärna haft ett enhetstest.
            boolean availableOffers = true;
            do {
                System.out.print("Tillgängliga erbjudande just nu:\n" +
                        "1. 50% av ordinarie pris\n" +
                        "Ange siffran för det alternativ du väljer: ");
                String thisOffer = input.nextLine();
                if (thisOffer.equals("1")) {
                    offer = (price * 0.5);
                    System.out.println("Enhetspris med rabatt: " + offer);
                    availableOffers = true;
                } else {
                    System.out.println("Vänligen ange ett av de tillgängliga alternativen.\n");
                    availableOffers = false;
                }
            } while (!availableOffers);
        } else {
            System.out.println("Inget erbjudande angivet, ordinarie pris gäller.");
        }
        // Här skulle jag gärna haft ett enhetstest.
        boolean correctPriceType;
        do {
            System.out.print("Ange kg för kilopris eller st för styckpris: ");
            String priceType = input.nextLine();
            if (!priceType.equals("st") && !priceType.equals("kg")) {
                System.out.println("Ditt val kunde inte läsas in. Vänligen försök igen.");
                correctPriceType = false;
            } else {
                Product t = new Product(name.toLowerCase(), price, priceType.toLowerCase(), productGroup.toLowerCase(), offer);
                productList.add(t);
                System.out.println();
                System.out.println("Varan är inlagd. Tryck 5 för att lägga in ny vara.\nTryck 0 för att avsluta eller 11 för att återgå till menyn.");
                correctPriceType = true;
            }
        } while (!correctPriceType);
    }
    private static void removeProduct () {
        // Här skulle jag gärna haft ett enhetstest.
        System.out.println("Ta bort produkt genom att fylla i kommande fält.");
        System.out.print("Vilket produkt vill du ta bort?: ");
        String removeOneProduct = input.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(removeOneProduct)) {
                productList.remove(i);
                System.out.println("Produkten är nu borttagen.");
            } else {
                System.out.println("\nProdukten ej funnen. Tryck 5 för att söka igen.");
                System.out.println("Tryck 0 för att avsluta programmet eller 11 för att återgå till medarbetar-menyn.");
            }
        }
    }
    private static void allProducts () {
        // Här skulle jag gärna haft ett enhetstest.
        if (productList.isEmpty()) {
            System.out.println("Det finns inga varor inlagda i systemet.");
        } else {
            System.out.println("Alla produkter: \n");
            int productIndex = 0;
            for (Product product : productList) {
                System.out.print(productIndex + 1 + ". ");
                System.out.println("Produkt: " + product.getName() + "\t");
                System.out.println("Produktgrupp: " + product.getProductGroup() + "\t");
                System.out.println("Pris: " + product.getPrice() + "/" + product.getPriceType() + "\t");
                System.out.println("Erbjudande: " + product.getOffer() + "\t");
                System.out.println();
                productIndex++;
            }
        }
        System.out.println("Tryck 0 för att avsluta eller 1 för att återgå till menyn.");
    }
}
