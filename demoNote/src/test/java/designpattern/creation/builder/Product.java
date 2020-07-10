package designpattern.creation.builder;

import lombok.Data;

/**
 * <p>Title: Product</p>
 * <p>Description: 影视，书籍等作品</p>
 * <p>Company: Intellifusion</p>
 *
 * @author Lzq
 * @version V1.0
 * @date 2019/7/4 9:31
 */
@Data
public abstract class Product {
    public String author;//作者
    public int funds=0;//耗资
    public String workName;//作品名称
    public String workType;//作品类型
    public String content;//其他信息

    public String printString() {
        return "Product [author=" + author + ", funds=" + funds + ", workName="
            + workName + ", workType=" + workType + ", content=" + content + "]";
    }
}
