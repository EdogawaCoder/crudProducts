-- Script para criar tabela de produtos

create table product (
	id uuid primary key,
	name varchar(150), 
	price decimal(10,2),
	quantity integer

);

-- Script para consultar os registros da tabela
select * from product;