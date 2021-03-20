
/**
    *    to execute the script
    *    mysql -u root -p < mysql_pidza.sql 
    *    create commande and choose which magasin
    *    choose pizza from pizza_list (an istance of table pizza will be created) same for ingrediants
    *    choose boisson from boisson_list (an istance of table boisson will be created)
    *    create pizza_commande same for boisson_commande
*/
CREATE DATABASE IF NOT EXISTS pidza;
use pidza;
CREATE TABLE IF NOT EXISTS Payment(
    payment_id int NOT NULL PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS responsable(
    responsable_id INT NOT NULL PRIMARY KEY,
    responsable_nom VARCHAR(255),
    responsable_prenom VARCHAR(255),
    responsable_username VARCHAR(255),
    responsable_password VARCHAR(255),
    responsable_email VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS magasin(
    magasin_id INT NOT NULL PRIMARY KEY,
    magasin_nom VARCHAR(255),
    magasin_wilaya VARCHAR(255),
    magasin_adress VARCHAR(255),
    responsable_id INT,
    FOREIGN KEY (responsable_id) REFERENCES responsable(responsable_id)


);
CREATE TABLE IF NOT EXISTS pizza_list(
    pizza_id INT NOT NULL PRIMARY KEY,
    pizza_type VARCHAR(255),
    pizza_photo VARCHAR(255), /* Link to the image */
    pizza_prix FLOAT

);
CREATE TABLE IF NOT EXISTS magasin_pizza_list(
   magasin_id INT,
   pizza_id INT,
   FOREIGN KEY (magasin_id) REFERENCES magasin(magasin_id),
   FOREIGN KEY (pizza_id) REFERENCES pizza_list(pizza_id), 
   UNIQUE (magasin_id, pizza_id )


);
CREATE TABLE IF NOT EXISTS boisson_list(
    boisson_id INT NOT NULL PRIMARY KEY,
    boisson_nom VARCHAR(255),
    boisson_photo VARCHAR(255), /* Link to the image */
    boisson_prix FLOAT
);
CREATE TABLE IF NOT EXISTS magasin_boisson_list(
   magasin_id INT,
   boisson_id INT,
   FOREIGN KEY (magasin_id) REFERENCES magasin(magasin_id),
   FOREIGN KEY (boisson_id) REFERENCES boisson_list(boisson_id), 
   UNIQUE (magasin_id, boisson_id )
);
CREATE TABLE IF NOT EXISTS ingrediant_list(
    ingrediant_id INT NOT NULL PRIMARY KEY,
    ingrediant_nom VARCHAR(255),
    ingrediant_prix FLOAT
);
CREATE TABLE IF NOT EXISTS magasin_ingrediant_list(
   magasin_id INT,
   ingrediant_id INT,
   FOREIGN KEY (magasin_id) REFERENCES magasin(magasin_id),
   FOREIGN KEY (ingrediant_id) REFERENCES ingrediant_list(ingrediant_id), 
   UNIQUE (magasin_id, ingrediant_id )
);
CREATE TABLE IF NOT EXISTS commande(
    commande_id INT NOT NULL PRIMARY KEY,
    commande_etat VARCHAR(255),
    commande_prix FLOAT,
    magasin_id INT,
    FOREIGN KEY (magasin_id) REFERENCES magasin(magasin_id)    

);
CREATE TABLE IF NOT EXISTS ingrediant(
    ingrediant_id INT NOT NULL PRIMARY KEY,
    ingrediant_nom VARCHAR(255), /* this would be better with set datatype but unfortunately we are short on time */ 
    ingrediant_prix FLOAT
);

CREATE TABLE IF NOT EXISTS pizza(
    pizza_id INT NOT NULL PRIMARY KEY,
    pizza_type VARCHAR(255),
    pizza_prix FLOAT /* we put this to save the record that the custumor has bough this pizza incase the shop has decided to higher the price */
);
CREATE TABLE IF NOT EXISTS pizza_ingrediant(
    pizza_id INT, 
    ingrediant_id INT,
    FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id), 
    FOREIGN KEY (ingrediant_id) REFERENCES ingrediant(ingrediant_id),
    UNIQUE (pizza_id, ingrediant_id)
);
CREATE TABLE IF NOT EXISTS commande_pizza(
    commande_id INT, 
    pizza_id INT,
    nombre_pizza INT,
    FOREIGN KEY (commande_id) REFERENCES commande(commande_id),
    FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id), 
    UNIQUE (commande_id, pizza_id)
);
CREATE TABLE IF NOT EXISTS boisson(
    boisson_id INT NOT NULL PRIMARY KEY,
    boisson_nom VARCHAR(255),
    boisson_prix FLOAT
);
CREATE TABLE IF NOT EXISTS commande_boisson(
    commande_id INT, 
    boisson_id INT,
    nombre_boisson INT,
    FOREIGN KEY (commande_id) REFERENCES commande(commande_id),
    FOREIGN KEY (boisson_id) REFERENCES boisson(boisson_id), 
    UNIQUE (commande_id, boisson_id)
);
CREATE TABLE IF NOT EXISTS client(
    client_id INT NOT NULL PRIMARY KEY,
    client_nom VARCHAR(255),
    client_prenom VARCHAR(255),
    client_email VARCHAR(255),
    client_password VARCHAR(255),
    client_username VARCHAR(255),
    client_adress VARCHAR(255),
    client_telephone VARCHAR(255),
    client_tokken VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS commande_client(
    commande_id INT, 
    client_id INT,  
    adress_livraison VARCHAR(255), 
    FOREIGN KEY (commande_id) REFERENCES commande(commande_id), 
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    UNIQUE (commande_id)
);
CREATE TABLE IF NOT EXISTS agent(
    agent_id INT NOT NULL PRIMARY KEY,
    agent_nom VARCHAR(255),
    agent_prenom VARCHAR(255),
    agent_email VARCHAR(255),
    agent_password VARCHAR(255),
    agent_username VARCHAR(255),
    agent_adress VARCHAR(255),
    agent_telephone VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS commande_agent(
    commande_id INT, 
    agent_id INT,  
    etat VARCHAR(255),   
    raison VARCHAR(255),
    FOREIGN KEY (commande_id) REFERENCES commande(commande_id), 
    FOREIGN KEY (agent_id) REFERENCES agent(agent_id),
    UNIQUE (commande_id)
);


INSERT INTO responsable values ( 1 , "afir" , "sofiane" , "fianso" , "abcd1234" , "sofiane@hotmail.com");
INSERT INTO responsable values ( 2 , "boumechta" , "mohamed" , "user" , "abcd1234" , "mohamed@hotmail.com");
INSERT INTO magasin values ( 1 , 'pizza hot' , 'alger' , 'ain naadja 1045 cite' , 1);
INSERT INTO magasin values ( 2 , 'burgger for you' , 'blida' , 'beni mered' , 2);

/* pizza part of commande*/
/*
INSERT INTO  pizza values( 1 , "mega" , 2000.00);
INSERT INTO  pizza values( 2 , "medium" ,  1500.00);
INSERT INTO  pizza values( 3 , "simple" ,  800.00);

INSERT INTO ingrediant values ( 1 , "fromage" , 50.00);
INSERT INTO ingrediant values ( 2 , "frite" , 70.00);
INSERT INTO ingrediant values ( 3 , "moutard" , 55.00);

INSERT INTO  pizza_ingrediant values ( 1 , 1);
INSERT INTO  pizza_ingrediant values ( 1 , 2);
INSERT INTO  pizza_ingrediant values ( 2 , 3);
*/
/* commande part*/
/*
INSERT INTO commande values(1,"pret", 5000.00 , 1);
INSERT INTO commande values(2,"pret", 5000.00 , 1);
INSERT INTO commande values(3,"pret", 5000.00 , 1);

INSERT INTO commande_pizza values(1,1,2);
INSERT INTO commande_pizza values(1,2,1);
INSERT INTO commande_pizza values(1,3,3);
*/
/* boisson part of commande*/
/*
INSERT INTO boisson values( 1 , "coca cola",  85.00);
INSERT INTO boisson values( 2 , "pepsi", 70.00);
INSERT INTO boisson values( 3 , "fanta", 70.00);

INSERT INTO commande_boisson values( 1 , 1 , 2);
INSERT INTO commande_boisson values( 1 , 3 , 1);
*/
/* pizza part of magasin */
INSERT INTO  pizza_list values( 1 , "mega","photoPizza1.png", 2000.00);
INSERT INTO  pizza_list values( 2 , "medium","photoPizza2.png", 1500.00);
INSERT INTO  pizza_list values( 3 , "simple","photoPizza3.png", 800.00);
/* magasin 1*/
INSERT INTO  magasin_pizza_list values( 1 , 1);
INSERT INTO  magasin_pizza_list values( 1 , 2);
INSERT INTO  magasin_pizza_list values( 1 , 3);
/*magasin 2 */
INSERT INTO  magasin_pizza_list values( 2 , 2);
INSERT INTO  magasin_pizza_list values( 2 , 3);
/* boisson part of magasin */
INSERT INTO boisson_list values( 1 , "coca cola", "photoBoisson1.png" , 85.00);
INSERT INTO boisson_list values( 2 , "pepsi",  "photoBoisson2.png" ,70.00);
INSERT INTO boisson_list values( 3 , "fanta", "photoBoisson3.png" , 70.00);
INSERT INTO boisson_list values( 4 , "sprit", "photoBoisson4.png" , 75.00);
/* magasin 1*/
INSERT INTO  magasin_boisson_list values( 1 , 1);
INSERT INTO  magasin_boisson_list values( 1 , 2);
INSERT INTO  magasin_boisson_list values( 1 , 3);
/* magasin 2*/
INSERT INTO  magasin_boisson_list values( 2 , 1);
INSERT INTO  magasin_boisson_list values( 2 , 3);
INSERT INTO  magasin_boisson_list values( 2 , 4);
/* ingerediant part of magasin */


INSERT INTO ingrediant_list values ( 1 , "fromage" , 50.00);
INSERT INTO ingrediant_list values ( 2 , "frite" , 70.00);
INSERT INTO ingrediant_list values ( 3 , "moutard" , 55.00);
INSERT INTO ingrediant_list values ( 4 , "ketchup" , 85.00);

/* magasin 1*/
INSERT INTO  magasin_ingrediant_list values( 1 , 1);
INSERT INTO  magasin_ingrediant_list values( 1 , 2);
INSERT INTO  magasin_ingrediant_list values( 1 , 3);
/* magasin 2*/
INSERT INTO  magasin_ingrediant_list values( 2 , 1);
INSERT INTO  magasin_ingrediant_list values( 2 , 2);
INSERT INTO  magasin_ingrediant_list values( 2 , 3);
INSERT INTO  magasin_ingrediant_list values( 2 , 4);


/* agent part */
INSERT INTO agent values( 1 , "mohand" , "toufik" , "toufik@hotmail.com" ,"abcd1234" , "toufik123" , "ain taya" , "055401524" );
INSERT INTO agent values( 2 , "samir" , "mohamed" , "mohamed@hotmail.com" ,"abcd1234" , "mohamed123" , "ain taya" , "055401524" );
INSERT INTO agent values( 3 , "raja" , "salima" , "salima@hotmail.com" ,"abcd1234" , "saima123" , "ain taya" , "055401524" );
/*
INSERT INTO commande_agent values( 1 , 1 , "en cours" , null);
INSERT INTO commande_agent values( 2 , 2 , "pas livrer" , "j'ai pas trouver le client");
INSERT INTO commande_agent values( 3 , 1 , "en cours" , null);
*/

/* client part */

INSERT INTO client values( 1 , "smain" , "younes" , "younes@hotmail.com" ,"abcd1234" , "younes" , "blida" , "055401524" ,"tokenXYZ");
INSERT INTO client values( 2 , "menai" , "yassin" , "yassin@hotmail.com" ,"abcd1234" , "yassin" , "blida" , "055401524" ,"tokenXYZ");
INSERT INTO client values( 3 , "miloudi" , "merwan" , "merwan@hotmail.com" ,"abcd1234" , "merwan" , "blida" , "055401524" ,"tokenXYZ");
INSERT INTO client values( 4 , "hamid" , "djamel" , "djamel@hotmail.com" ,"abcd1234" , "djemal" , "alger" , "055401524" ,"tokenXYZ");

/*
INSERT INTO commande_client values( 1 , 1 , "alger" );
INSERT INTO commande_client values( 2 , 2 , null );
INSERT INTO commande_client values( 3 , 1 , "oran" );
*/


