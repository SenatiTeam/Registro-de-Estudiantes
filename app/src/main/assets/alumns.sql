BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "alumns" (
	"codigo"	char(12) UNIQUE,
	"nombre"	varchar(200),
	"apellido"	varchar(200),
	"telefono"	varchar(12),
	"created_at"	datetime,
	"updated_at"	datetime
);
INSERT INTO "alumns" ("codigo","nombre","apellido","telefono","created_at","updated_at") VALUES ('abc001','Pepe','Flores','951258741','07/09/2026 19:26:00','07/09/2026 19:26:00'),
 ('acb002','Ana','Ramos','985451255','07/09/2026 19:28:00','07/09/2026 19:28:00');
COMMIT;
