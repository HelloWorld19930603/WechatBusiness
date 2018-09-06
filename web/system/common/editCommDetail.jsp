<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<input type="hidden" name="img1" id="img1" value="${detail1.url}">
<input type="hidden" name="img2" id="img2" value="${detail2.url}">
<input type="hidden" name="id1" id="id1" value="${detail1.id}">
<input type="hidden" name="id2" id="id2" value="${detail2.id}">
<fieldset title="商品详情">
    <legend></legend>
    <div class="form-group">
        <label class="col-md-2 control-label span3"></label>
        <div class="col-md-6">
            <c:if test="${detail1 != null}">
                <img  id="img_2"src="${detail1.url}" width="100px" height="100px">
            </c:if>
            <c:if test="${detail1 == null}">
                <img id="img_2" src="/images/default.png" width="100px" height="100px">
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label ">商品详情上传</label>
        <div class="col-md-6">
            <div class="input-group">
                <input id="photoCover2" class="form-control" readonly type="text">
                <label class="input-group-btn">
                    <input id="file2" type="file" name="file2"
                           style="left: -9999px; position: absolute;">
                    <span class="btn btn-default">浏览</span>
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 control-label span3"></label>
        <div class="col-md-6">
            <c:if test="${detail2 != null}">
                <img id="img_3" src="${detail2.url}" width="100px" height="100px">
            </c:if>
            <c:if test="${detail2 == null}">
                <img id="img_3" src="/images/default.png" width="100px" height="100px">
            </c:if>
        </div>
    </div>
    <div class="form-group">

        <label class="col-md-2 control-label ">商品详情上传</label>
        <div class="col-md-6">
            <div class="input-group">
                <input id="photoCover3" class="form-control" readonly type="text">
                <label class="input-group-btn">
                    <input id="file3" type="file" name="file3"
                           style="left: -9999px; position: absolute;">
                    <span class="btn btn-default">浏览</span>
                </label>
            </div>
        </div>
    </div>
</fieldset>
<button class="btn btn-info finish" id='finished' type="button">
    完成
</button>
