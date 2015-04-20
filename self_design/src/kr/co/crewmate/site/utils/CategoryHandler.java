package kr.co.crewmate.site.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.model.category.Category;

/**
 * 클래스명: <code>CategoryHandler</code>
 *
 * <pre>
 *  카테고리목록을 메모리에 관리하는 클래스
 * </pre>
 *
 * @author sist818
 * @date 2013. 4. 16.
 *
 */
public class CategoryHandler {

    private List<Category> categorys;
    
    private Map<String, List<Category>> parentIndex = new HashMap<String, List<Category>>();
    
    private Map<String, Category> categoryIndex = new HashMap<String, Category>();
    
    public CategoryHandler(List<Category> categorys) {
        this.categorys = categorys;
        init();
    }

    private void init() {
        for (Category category: categorys) {
            String key = category.getPrntCtgrId();
            if (category.getUseYn()) {
                if (parentIndex.containsKey(key)) {
                    parentIndex.get(key).add(category);
                } else {
                    List<Category> items = new ArrayList<Category>();
                    items.add(category);
                    parentIndex.put(key, items);
                }
            }
            
            this.categoryIndex.put(category.getCtgrId(), category);
        }
    }
    
    public List<Category> getCategorysByParentId(String parentCategoryId) {
        return this.parentIndex.get(parentCategoryId);
    }

    public Category getCategoryById(String categoryId) {
        return this.categoryIndex.get(categoryId);
    }
    
    /**
     * 해당하는 부모카테고리아이디의 자식카테고리 목록을 반환한다.(사용여부룰 null로 설정할 경우 전부 반환) 
     * @param prntCtgrId 부모카테고리아이디
     * @param useYn 사용여부
     * @return
     */
    public List<Category> getCategoryList(String prntCtgrId, Boolean useYn) {
        List<Category> childCategoryList = new ArrayList<Category>();

        for(Category category: categorys) {
            String tempPrntCtgrId = category.getPrntCtgrId();
        
            if (StringUtils.equals(tempPrntCtgrId, prntCtgrId)) {
                if(useYn == null) {
                    childCategoryList.add(category);
                } else if(useYn != null && (category.getUseYn() == useYn) ) {
                    childCategoryList.add(category);
                }
            }
        }

        return childCategoryList;
    }
}
