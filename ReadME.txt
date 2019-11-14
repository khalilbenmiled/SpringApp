*************************** MICROSERVICES ******************************************
Eurka : 		port 8761
Gateway :		port 8762
Ms-GestionProduit	port 8181
Ms-GestionEntrepot	port 8282
Ms-GestionLivraison	port 8383
Ms-GestionClient	port 8484
Ms-GestionCommande	port 8585
Ms-Node			port 3000 (steps to run : >docker-compose build 
						  >docker-compose up )

*************************** API Ms-GestionProduit **********************************
GET 	http://192.168.99.100:8762/gestion-produit/produits 				----- Affichage des produits
GET	http://192.168.99.100:8762/gestion-produit/produits/id  			----- Recherche produit par ID
GET	http://192.168.99.100:8762/gestion-produit/produits/ByLibelle			----- Recherche produit par LIBELLE
GET	http://192.168.99.100:8762/gestion-produit/produits/categories			----- Affichage des categories à partir du microservice NODE
POST 	http://192.168.99.100:8762/gestion-produit/produits 				----- Ajouter produit
POST	http://192.168.99.100:8762/gestion-produit/produits/addProduitToStock		----- Affecter un produit à un stock
DELETE	http://192.168.99.100:8762/gestion-produit/produits/id				----- Supprimer produit par ID
PUT	http://192.168.99.100:8762/gestion-produit/produits/id				----- Modifier produit par ID


GET 	http://192.168.99.100:8762/gestion-produit/stock				----- Affichage des stocks
GET 	http://192.168.99.100:8762/gestion-produit/stock/id				----- Recherche stock par ID
POST	http://192.168.99.100:8762/gestion-produit/stock				----- Ajouter stock


*************************** API Ms-GestionEntrepot **********************************
GET 	http://192.168.99.100:8762/gestion-entrepot/equipements				----- Affichage des equipements
GET	http://192.168.99.100:8762/gestion-entrepot/equipements/id			----- Recherche equipement par ID
GET	http://192.168.99.100:8762/gestion-entrepot/equipements/ByCode/code		----- Recherche equipement par CODE
POST	http://192.168.99.100:8762/gestion-entrepot/equipements				----- Ajouter equipement
POST	http://192.168.99.100:8762/gestion-entrepot/equipementsaddEToE			----- Affecter un equipement à un entrepot
PUT	http://192.168.99.100:8762/gestion-entrepot/equipements/id			----- Modifier equipement par ID
PUT	http://192.168.99.100:8762/gestion-entrepot/equipements/qt/id			----- Modifier la quantite d'equipement par ID

GET 	http://192.168.99.100:8762/gestion-entrepot/entrepot				----- Affichage des entrepots
GET	http://192.168.99.100:8762/gestion-entrepot/entrepot/id				----- Recherche entrepot par ID
GET	http://192.168.99.100:8762/gestion-entrepot/entrepot/lieu			----- Recherche entrepot par LIEU
POST	http://192.168.99.100:8762/gestion-entrepot/entrepot				----- Ajouter entrepot

*********************************************** API Ms-GestionLivraison ***********************************************
GET 	http://192.168.99.100:8762/gestion-livraison/api/livraison/listerLivraisons	----- Affichage des livraisons
GET 	http://192.168.99.100:8762/gestion-livraison/api/livraison/getLivraisonById	----- Recherche livraison par ID
POST 	http://192.168.99.100:8762/gestion-livraison/api/livraison/ajouterLivraison	----- Ajouter Livrasion
POST 	http://192.168.99.100:8762/gestion-livraison/api/livraison/validerLivraison	----- Valider une Livrasion
POST 	http://192.168.99.100:8762/gestion-livraison/api/livraison/annulerLivraison	----- Annuler une Livrasion
DELETE  http://192.168.99.100:8762/gestion-livraison/api/livraison/deleteLivraisonById	----- Supprimer une livraison

POST	http://192.168.99.100:8762/gestion-livraison/api/livreur/			----- Ajouter un livreur
POST	http://192.168.99.100:8762/gestion-livraison/api/livreur/affecterLivraison	----- Affecter une livraison à un livreur
PUT	http://192.168.99.100:8762/gestion-livraison/api/livreur/id			----- Modifier un livreur par ID
DELETE	http://192.168.99.100:8762/gestion-livraison/api/livreur/id			----- Supprimer un livreur par ID

*********************************************** API Ms-GestionClient ***********************************************
GET	http://192.168.99.100:8762/gestion-client/clients				----- Affichage des clients
GET	http://192.168.99.100:8762/gestion-client/clients/name				----- Recherche client par NOM
GET	http://192.168.99.100:8762/gestion-client/clients/nbrContact			----- Retourner les nombres de contacts d'un client
POST	http://192.168.99.100:8762/gestion-client/clients				----- Ajouter client
PUT	http://192.168.99.100:8762/gestion-client/clients/id				----- Modifier client par ID
DELETE	http://192.168.99.100:8762/gestion-client/clients/id				----- Supprimer client par ID

GET	http://192.168.99.100:8762/gestion-client/contacts				----- Affichage des contacts
GET	http://192.168.99.100:8762/gestion-client/contacts/type/type			----- Affichage des contacts par TYPE
POST	http://192.168.99.100:8762/gestion-client/contacts				----- Ajouter un contact
PUT	http://192.168.99.100:8762/gestion-client/contacts/id				----- Modifier un contact par ID

*********************************************** API Ms-GestionCommande ***********************************************
GET	http://192.168.99.100:8762/gestion-commande/commandes				----- Affichage des commandes
POST	http://192.168.99.100:8762/gestion-commande/api/commande			----- Ajouter commande
PUT	http://192.168.99.100:8762/gestion-commande/api/commande/id			----- Modifier commande par ID
DELETE	http://192.168.99.100:8762/gestion-commande/api/commande/id			----- Supprimer commande par ID

GET 	http://192.168.99.100:8762/gestion-commande/factures				----- Affichage des factures
POST	http://192.168.99.100:8762/gestion-commande/api/facture				----- Ajoute facture
PUT	http://192.168.99.100:8762/gestion-commande/api/facture/id			----- Modifier facture par ID
DELETE	http://192.168.99.100:8762/gestion-commande/api/facture/id			----- Supprimer facture par ID

*********************************************** API Ms-Node (Categorie) ***********************************************
GET	http://192.168.99.100:8762/ms-node/api						----- Affichage des categories
GET	http://192.168.99.100:8762/ms-node/api/id					----- Rechercher categorie par ID
POST	http://192.168.99.100:8762/ms-node/api						----- Ajouter categorie
DELETE	http://192.168.99.100:8762/ms-node/api/ID					----- Supprimer categorie par ID
PUT	http://192.168.99.100:8762/ms-node/api/id					----- Modifier categorie par ID
































