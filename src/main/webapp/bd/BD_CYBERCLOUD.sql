DROP DATABASE IF EXISTS BD_CYBERCLOUD;

CREATE DATABASE BD_CYBERCLOUD;

USE BD_CYBERCLOUD;

CREATE TABLE TIPO(
	ID_TIPO			INT AUTO_INCREMENT	PRIMARY KEY,
    NOM_TIPO		VARCHAR(13)			NOT NULL
);

CREATE TABLE USUARIO(
	ID_USU			INT	AUTO_INCREMENT	PRIMARY KEY,
	NOM_USU			VARCHAR(40)			NOT NULL,
	APEPA_USU		VARCHAR(40)			NOT NULL,
	APEMA_USU		VARCHAR(40)			NOT NULL,
	FONO_USU		VARCHAR(40)			NOT NULL,
	EMAIL_USU		VARCHAR(40)			NOT NULL,
	PASSWORD_USU	VARCHAR(40)			NOT NULL,
    ID_TIPO			INT					REFERENCES TIPO
);

CREATE TABLE MENSAJE(
	ID_MENSAJE		INT	AUTO_INCREMENT	PRIMARY KEY,
	NOMBRE			VARCHAR(40)			NOT NULL,
	APEPA			VARCHAR(40)			NOT NULL,
	APEMA			VARCHAR(40)			NOT NULL,
	EMAIL			VARCHAR(40)			NOT NULL,
	FONO			CHAR(9)				NOT NULL,
	DESC_MENSAJE	VARCHAR(500)		NOT NULL
);

CREATE TABLE CHARLA(
	ID_CHARLA		INT	AUTO_INCREMENT	PRIMARY KEY,
    TEMA			VARCHAR(50)			NOT NULL,
    CUPOS			INT					NOT NULL
);

CREATE TABLE EVENTO(
	ID_EVENTO		CHAR(5)				PRIMARY KEY,
    FECHA_REG		DATE				NOT NULL,
    ID_USU			INT					REFERENCES USUARIO,
    ID_CHARLA		INT					REFERENCES CHARLA
);

INSERT INTO TIPO VALUES (null,'ADMINISTRADOR'), (null,'CLIENTE');

INSERT INTO USUARIO VALUES 	(null,'Piero','Caro','Jara','912345677','piero@gmail.com','Piero123',1),
                            (null,'Jhonny','Chávez','Retuerto','934567891','jhonny@hotmail.com','Jhonny123',1),
                            (null,'Maykler','Quispe','Payehuanca','956789013','maykler@outlook.com','Maykler123',1),
                            (null,'Doris','Silva','Chávez','978901235','doris@gmail.com','Doris123',1),
                            (null,'Mariana','Wismann','Cáceres','999876544','mariana@hotmail.com','Mariana123',1),
                            (null,'Pablo','Millan','Sanz','912345679','pablo@hotmail.com','Pablo123',2),
                            (null,'Ramón', 'Gómez', 'Herrera', '923456790', 'ramon@gmail.com', 'Ramon123', 2),
                            (null,'Marta', 'Martínez', 'López', '945678902', 'marta@hotmail.com', 'Marta123', 2),
                            (null,'Roberto', 'Ramírez', 'Ortega', '967890124', 'roberto@outlook.com', 'Roberto123', 2),
                            (null,'Johanna', 'Rojas', 'Gutiérrez', '989012346', 'johanna@gmail.com', 'Johanna123', 2);
                            
INSERT INTO MENSAJE VALUES 	(null,'Juan', 'Pérez', 'Gómez', 'juan@hotmail.com', '912345678', 'He detectado un comportamiento sospechoso en mi cuenta, ¿pueden verificarlo?'),
							(null,'María', 'López', 'Fernández', 'maria@gmail.com', '934567890', 'Quisiera obtener consejos sobre cómo proteger mi información personal en línea.'),
							(null,'Carlos', 'González', 'Rodríguez', 'carlos@outlook.com', '956789012', 'Recibí un correo electrónico sospechoso, ¿cómo puedo verificar si es legítimo?'),
							(null,'Ana', 'Martínez', 'Sánchez', 'ana@hotmail.com', '978901234', 'Me gustaría saber cómo fortalecer la seguridad de mi red doméstica.'),
							(null,'Pedro', 'Ramírez', 'Hernández', 'pedro@gmail.com', '999876543', '¿Cuáles son las mejores prácticas para crear contraseñas seguras?'),
							(null,'Laura', 'Díaz', 'Gutiérrez', 'laura@outlook.com', '912345678', '¿Cómo puedo proteger mi computadora contra malware y virus?'),
							(null,'Miguel', 'Herrera', 'Ortega', 'miguel@hotmail.com', '923456789', '¿Hay medidas adicionales que pueda tomar para proteger mi privacidad en línea?'),
							(null,'Carmen', 'Vargas', 'Jiménez', 'carmen@gmail.com', '945678901', 'Necesito asesoramiento sobre cómo evitar ser víctima de phishing en internet.'),
							(null,'Ricardo', 'Fuentes', 'Lara', 'ricardo@outlook.com', '967890123', '¿Cuál es la mejor manera de asegurar mi smartphone contra amenazas cibernéticas?'),
							(null,'Isabel', 'Rojas', 'Flores', 'isabel@hotmail.com', '989012345', '¿Hay recomendaciones específicas para proteger mi información al usar redes Wi-Fi públicas?'),
							(null,'Alejandro', 'Ortiz', 'Mendoza', 'alejandro@gmail.com', '912345678', 'Estoy interesado en aprender sobre ciberseguridad, ¿pueden sugerirme recursos y cursos?'),
							(null,'Sofía', 'Gómez', 'Castro', 'sofia@outlook.com', '923456789', '¿Cómo puedo realizar copias de seguridad de manera segura y eficiente?'),
							(null,'Javier', 'Núñez', 'Santos', 'javier@hotmail.com', '945678901', 'Quiero saber más sobre el cifrado de datos y su importancia en la seguridad informática.'),
							(null,'Gabriela', 'Martínez', 'López', 'gabriela@gmail.com', '967890123', 'Necesito ayuda para configurar un firewall en mi red doméstica.'),
							(null,'Fernando', 'Sánchez', 'García', 'fernando@outlook.com', '989012345', 'He notado actividad inusual en mi cuenta bancaria en línea, ¿cómo puedo asegurarme de que no haya sido comprometida?'),
							(null,'Diana', 'Castillo', 'Morales', 'diana@hotmail.com', '912345678', '¿Cuáles son las señales de advertencia de un ataque de ransomware y cómo puedo protegerme?'),
							(null,'Rafael', 'Gómez', 'Hernández', 'rafael@gmail.com', '923456789', '¿Hay medidas adicionales que pueda tomar para proteger mi identidad en línea?'),
							(null,'Cecilia', 'Rodríguez', 'Díaz', 'cecilia@outlook.com', '945678901', '¿Cómo puedo saber si mi dispositivo está infectado con malware y cómo puedo eliminarlo?'),
							(null,'Héctor', 'Mendoza', 'Rojas', 'hector@hotmail.com', '967890123', '¿Qué precauciones debo tomar al descargar e instalar aplicaciones en mi computadora o teléfono?'),
							(null,'Valentina', 'Gutiérrez', 'Torres', 'valentina@gmail.com', '989012345', '¿Cuál es la importancia de mantener mis sistemas operativos y software actualizados para la seguridad informática?');

INSERT INTO CHARLA VALUES	(null,'Implementación de seguridad en mi sitio web',5),
							(null,'Nuevos avances en soluciones de ciberseguridad',10),
                            (null,'Estándares de seguridad en la nube',15);

DROP PROCEDURE IF EXISTS `USP_LSTMENSAJES`;

CREATE PROCEDURE USP_LSTMENSAJES()
	SELECT
	CONCAT(NOMBRE,' ',APEPA,' ',APEMA) AS 'NOMBRE',
	FONO,
	EMAIL,
	DESC_MENSAJE
	FROM MENSAJE;
    
CALL USP_LSTMENSAJES();

DROP PROCEDURE IF EXISTS `USP_LSTUSUARIOS`;

CREATE PROCEDURE USP_LSTUSUARIOS()
	SELECT
    U.ID_USU,
    U.NOM_USU,
	CONCAT(U.APEPA_USU,' ',U.APEMA_USU) AS 'APELLIDOS',
	U.FONO_USU,
	U.EMAIL_USU,
    T.NOM_TIPO
	FROM USUARIO U
    JOIN TIPO T ON U.ID_TIPO = T.ID_TIPO;
    
CALL USP_LSTUSUARIOS();

DROP PROCEDURE IF EXISTS `USP_LSTUSUARIOSPORCHARLA`;

CREATE PROCEDURE USP_LSTUSUARIOSPORCHARLA(IN IDCHARLA INT)
	SELECT
    C.ID_CHARLA,
    U.ID_USU,
	CONCAT(U.NOM_USU,' ',U.APEPA_USU,' ',U.APEMA_USU) AS 'NOMBRE',
	U.FONO_USU,
	U.EMAIL_USU
	FROM EVENTO E
    INNER JOIN USUARIO U ON E.ID_USU = U.ID_USU
    INNER JOIN CHARLA C ON E.ID_CHARLA = C.ID_CHARLA
    WHERE E.ID_CHARLA = IDCHARLA;
    
CALL USP_LSTUSUARIOSPORCHARLA(1);