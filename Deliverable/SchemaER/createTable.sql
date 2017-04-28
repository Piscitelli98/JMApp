create table utenti(
	username varchar(32) primary key,
	psw char(32) not null,
    amministratore enum('si','no') default 'no',
    nome varchar(32) not null,
    cognome varchar(32) not null,
    email varchar(32)
);
create table categoria(
    nomeCategoria varchar(64) PRIMARY KEY
);
create table circolare(
	numero int(32) AUTO_INCREMENT PRIMARY KEY,
    nome varchar(64) not null,
    privacy enum('pubblica','privata') DEFAULT 'privata',
    descrizione varchar(128),
    testo varchar(64) not null,
    username varchar(32) REFERENCES utenti(username)
    	on UPDATE CASCADE
    		on DELETE no action,
    nomeCategoria varchar(64) REFERENCES categoria(nomeCategoria)
    	on UPDATE CASCADE
    		on DELETE SET null    
);
create table destinatari(
    nomeDestinatario varchar(64) PRIMARY KEY
);
create table riguarda(
    nomeDestinatario varchar(64) REFERENCES destinatari(nomeDestinatario)
    	on UPDATE CASCADE
    		on DELETE set null,
    numeroCircolare int(32) REFERENCES circolare(numero)
    	on UPDATE CASCADE
    		on  DELETE CASCADE,
    PRIMARY KEY(nomeDestinatario, numeroCircolare)
)