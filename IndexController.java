package jp.co.internous.peach.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.peach.model.domain.MstCategory;
import jp.co.internous.peach.model.domain.MstProduct;
import jp.co.internous.peach.model.form.SearchForm;
import jp.co.internous.peach.model.mapper.MstCategoryMapper;
import jp.co.internous.peach.model.mapper.MstProductMapper;
import jp.co.internous.peach.model.session.LoginSession;

@Controller
@RequestMapping("/peach")
public class IndexController {
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {

		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = new Random().nextInt(1_000_000_000);
			tmpUserId *= -1;
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstCategory> categories = categoryMapper.find();
		
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
	
	@RequestMapping("/searchItem")
	public String index(SearchForm f, Model m) {
		List<MstProduct> products = null;
		
		String keywords = f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		if (f.getCategory() == 0) {
			products = productMapper.findByProductName(keywords.split(" "));
		} else {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywords.split(" "));
		
		}
		
		List<MstCategory> categories = categoryMapper.find();
		
		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory());
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		
		return "index";
		
	}
}
