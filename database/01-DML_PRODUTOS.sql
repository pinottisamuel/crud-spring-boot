create table produtos (
	id int auto_increment primary key,
	descricao varchar(255) not null,
	valor decimal(10.2),
	data_cadastro date,	
	quantidade int,
	observacao varchar(255)
);