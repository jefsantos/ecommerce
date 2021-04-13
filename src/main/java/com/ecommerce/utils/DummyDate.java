package com.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Cidade;
import com.ecommerce.model.Cliente;
import com.ecommerce.model.Endereco;
import com.ecommerce.model.Estado;
import com.ecommerce.model.ItemPedido;
import com.ecommerce.model.Pagamento;
import com.ecommerce.model.PagamentoComBoleto;
import com.ecommerce.model.PagamentoComCartao;
import com.ecommerce.model.Pedido;
import com.ecommerce.model.Produto;
import com.ecommerce.model.enums.EstadoPagamento;
import com.ecommerce.model.enums.TipoCliente;
import com.ecommerce.repositories.CategoriaRepository;
import com.ecommerce.repositories.CidadeRepository;
import com.ecommerce.repositories.ClienteRepository;
import com.ecommerce.repositories.EnderecoRepository;
import com.ecommerce.repositories.EstadoRepository;
import com.ecommerce.repositories.ItemPedidoRepository;
import com.ecommerce.repositories.PagamentoRepository;
import com.ecommerce.repositories.PedidoRepository;
import com.ecommerce.repositories.ProdutoRepository;

@Component
public class DummyDate {
	
    @Autowired
	private CategoriaRepository catRepo;
    
    @Autowired
    private ProdutoRepository prodRepo;
    
    @Autowired
    private CidadeRepository cidadeRepo;
    

    @Autowired
    private EstadoRepository estadoRepo;
    
    @Autowired
    private ClienteRepository clienteRepo;
    

    @Autowired
    private EnderecoRepository enderecoRepo;
    
    @Autowired
    private PedidoRepository pedidoRepo;
    
    @Autowired
    private PagamentoRepository pagamentoRepo;

    @Autowired
    private ItemPedidoRepository itemPedidoRepo;
    
    
    
	
//	@PostConstruct
	public void Savedados() throws ParseException {
		
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "INFORMATICA");
		Categoria cat2 = new Categoria(null, "ESCRITORIO");
		Categoria cat3 = new Categoria(null, "CAMA MESA BANHO");
		Categoria cat4 = new Categoria(null, "ELETRONICOS");
		Categoria cat5 = new Categoria(null, "JARDINAGEM");
		Categoria cat6 = new Categoria(null, "DECORACAO");
		Categoria cat7 = new Categoria(null, "PERFUMARIA");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		Estado est1 =new Estado(null, "Minas Gerais");
		Estado est2 =new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		Cliente cli1 = new Cliente(null, "Maria Antonia", "maria@maria", "2545645454", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("545465-46540","44445-45645"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto", "Jardim", "07853055", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "301", "casa", "Rural", "078111055", cli1, c2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		


		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1 , ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1 , ped2));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
		
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		catRepo.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
		prodRepo.saveAll(Arrays.asList(p1, p2,p3));
		estadoRepo.saveAll(Arrays.asList(est1,est2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(e1,e2)) ;
		
		pedidoRepo.saveAll(Arrays.asList(ped1,ped2)) ;
		pagamentoRepo.saveAll(Arrays.asList(pgto1,pgto2)) ;
		
		itemPedidoRepo.saveAll(Arrays.asList(ip1,ip2,ip3)) ;
	
	}
}
