
/**
    *    to execute the script
    *    mysql -u root -p < mysql_pidza.sql 
*/
CREATE DATABASE IF NOT EXISTS pidza;
use pidza;
CREATE TABLE IF NOT EXISTS Payment(
    payment_id int NOT NULL PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS Responsable(
    responsable_id INT NOT NULL PRIMARY KEY,
    responsable_nom VARCHAR(255),
    responsable_prenom VARCHAR(255),
    responsable_username VARCHAR(255),
    responsable_password VARCHAR(255),
    responsable_email VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Magasin(
    magasin_id INT NOT NULL PRIMARY KEY,
    magasin_nom VARCHAR(255),
    magasin_wilaya VARCHAR(255),
    magasin_adress VARCHAR(255),
    responsable_id INT,
    FOREIGN KEY (responsable_id) REFERENCES Responsable(responsable_id)


);
CREATE TABLE IF NOT EXISTS Commande(
    commande_id INT NOT NULL PRIMARY KEY,
    commande_etat VARCHAR(255),
    commande_prix FLOAT,
    commande_client INT,
    commande_agent INT,
    magasin_id INT,
    FOREIGN KEY (magasin_id) REFERENCES Magasin(magasin_id)    

);
CREATE TABLE IF NOT EXISTS Ingrediant(
    ingrediant_id INT NOT NULL PRIMARY KEY,
    ingrediant_nom VARCHAR(255), /* this would be better with set but unfortunately we are short on time */ 
    ingrediant_prix FLOAT
);
CREATE TABLE IF NOT EXISTS Pizza_ingrediant(
    pizza_id INT, 
    ingrediant_id INT,
    FOREIGN KEY (pizza_id) REFERENCES Pizza(pizza_id), 
    FOREIGN KEY (ingrediant_id) REFERENCES Ingrediant(ingrediant_id),
    UNIQUE (pizza_id, ingrediant_id)
);
CREATE TABLE IF NOT EXISTS Pizza(
    pizza_id INT NOT NULL PRIMARY KEY,
    pizza_type VARCHAR(255),
    pizza_photo VARCHAR(255), /* Link to the image */
    pizza_prix FLOAT
);
CREATE TABLE IF NOT EXISTS Commande_pizza(
    commande_id INT, 
    pizza_id INT,
    nombre_pizza INT,
    FOREIGN KEY (commande_id) REFERENCES Commande(commande_id),
    FOREIGN KEY (pizza_id) REFERENCES Pizza(pizza_id), 
    UNIQUE (commande_id, pizza_id)
);
CREATE TABLE IF NOT EXISTS Boisson(
    boisson_id INT NOT NULL PRIMARY KEY,
    boisson_nom VARCHAR(255),
    boisson_photo VARCHAR(255), /* Link to the image */
    boisson_prix FLOAT
);
CREATE TABLE IF NOT EXISTS Commande_boisson(
    commande_id INT, 
    boisson_id INT,
    nombre_boisson INT,
    FOREIGN KEY (commande_id) REFERENCES Commande(commande_id),
    FOREIGN KEY (boisson_id) REFERENCES Boisson(boisson_id), 
    UNIQUE (commande_id, boisson_id)
);
CREATE TABLE IF NOT EXISTS Client(
    client_id INT NOT NULL PRIMARY KEY,
    client_nom VARCHAR(255),
    client_prenom VARCHAR(255),
    client_email VARCHAR(255),
    client_password VARCHAR(255),
    client_username VARCHAR(255),
    client_adress VARCHAR(255),
    client_telephone VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Commande_client(
    commande_id INT, 
    client_id INT,  
    adress_livraison VARCHAR(255), 
    FOREIGN KEY (commande_id) REFERENCES Commande(commande_id), 
    FOREIGN KEY (client_id) REFERENCES Client(client_id),
    UNIQUE (commande_id, client_id)
);
CREATE TABLE IF NOT EXISTS Agent(
    agent_id INT NOT NULL PRIMARY KEY,
    agent_nom VARCHAR(255),
    agent_prenom VARCHAR(255),
    agent_email VARCHAR(255),
    agent_password VARCHAR(255),
    agent_username VARCHAR(255),
    agent_adress VARCHAR(255),
    agent_telephone VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Commande_agent(
    commande_id INT, 
    agent_id INT,  
    etat VARCHAR(255),   
    raison VARCHAR(255),
    FOREIGN KEY (commande_id) REFERENCES Commande(commande_id), 
    FOREIGN KEY (agent_id) REFERENCES Agent(agent_id),
    UNIQUE (commande_id, agent_id)
);
