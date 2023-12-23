-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id int4 NOT NULL,
	"name" varchar(255) NULL,
	price varchar(255) NULL,
	quantity varchar(255) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);


INSERT INTO public.product (id,"name",price,quantity) VALUES
	 (1,'Laptop','1399','1'),
	 (2,'Headphone','499','2'),
	 (3,'Keychron K10','199','1'),
	 (6,'Google Nest','239.99','34'),
	 (7,'Google Thermostat','29.99','12'),
	 (4,'Logitech Mouse','14.99','10'),
	 (0,'Google Thermostat','29.99','12');
