package com.ict.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.member.vo.MemberVO;
import com.ict.shop.service.ShopService;
import com.ict.shop.vo.CartVO;
import com.ict.shop.vo.ShopVO;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	
	
	
	@GetMapping("/shop")
	public ModelAndView getShopList(String category) {
		try {
			ModelAndView mv = new ModelAndView("shop/product_list");
			if (category == null || category == "") {
				category = "ele002";
			}
			
			List<ShopVO> shop_list = shopService.getShopList(category);
			if (shop_list !=null) {
				mv.addObject("shop_list", shop_list);
				return mv;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@GetMapping("/shop_detail")
	public ModelAndView getShopDetail(@RequestParam("shop_idx") String shop_idx) {
		try {
			ModelAndView mv = new ModelAndView("shop/product_content");
			ShopVO svo = shopService.getShopDetail(shop_idx);
			if (svo != null) {
				mv.addObject("svo", svo);
				return mv;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@GetMapping("/shop_addCart")
	public ModelAndView getShopAddCart(@ModelAttribute("shop_idx")String shop_idx,
			HttpSession session) {
		try {
			String loginchk = (String) session.getAttribute("loginchk");
			if(loginchk.equals("ok")) {
				ModelAndView mv = new ModelAndView("redirect:/shop_detail");
				
				//로그인한 정보를 가져오자
				MemberVO mvo = (MemberVO) session.getAttribute("mvo2");
				
				//제품 정보를 가져오자 (이름만 가져오면 된다.)
				ShopVO svo = shopService.getShopDetail(shop_idx);
				
				
				// 카트 리스트에 해당 제품번호와 사용자의 m_id와 해당 제품번호가 있는지(수량1증가) 없는지(카트 추가)판별하자
				CartVO cartVO  = shopService.getCartChk(mvo.getM_id(), svo.getP_num());
				
				if (cartVO == null) {
					//카트가 비어있으므로 카트 테이블에 추가 (insert)
					CartVO cavo = new CartVO();
					cavo.setP_num(svo.getP_num());
					cavo.setP_name(svo.getP_name());
					cavo.setP_price(String.valueOf(svo.getP_price()));
					cavo.setP_saleprice(String.valueOf(svo.getP_saleprice()));
					cavo.setM_id(mvo.getM_id());
					
					int result = shopService.getCartInsert(cavo);
					
					
				}else {
					// 카트에 있으므로 수량 증가 (update)
					int result = shopService.getCartUpdate(cartVO);
				}
				return mv;
			}else {
				return new ModelAndView("sns/login_error");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/shop_showCart")
	public ModelAndView getShopShowCart(HttpSession session) {
		try {
			String loginchk = (String) session.getAttribute("loginchk");
			if(loginchk.equals("ok")) {
				ModelAndView mv = new ModelAndView("shop/cartList");
				//로그인한 사람의 정보를 가져와서 카트에 검색 후 carttlist에 넘기자
				MemberVO mvo = (MemberVO) session.getAttribute("mvo2");
				
				List<CartVO> cart_list = shopService.getCartList(mvo.getM_id());
				
				if (cart_list != null) {
					mv.addObject("cart_list", cart_list);
				}
					
				return mv;
			}else {
				return new ModelAndView("sns/login_error");
			} 
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("sns/login_error");
		}
	}
	
	@PostMapping("/cart_edit")
	public ModelAndView getShopCartEdit(CartVO cavo) {
		try {
			ModelAndView mv = new ModelAndView("redirect:/shop_showCart");
			int result = shopService.getCartEdit(cavo);
			if(result>0) {
				return mv;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/cart_delete")
	public ModelAndView getShopCartDelete(String cart_idx) {
		try {
			ModelAndView mv = new ModelAndView("redirect:/shop_showCart");
			int result = shopService.getCartDelete(cart_idx);
			if(result>0) {
				return mv;
			}
			return null;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@GetMapping("/shop_add_form")
	public ModelAndView getShopAddForm() {
		return new ModelAndView("shop/product_insert");
	}
}
