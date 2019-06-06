<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- CourseContentMain -->
<div class="col-md-4 col-md-offset-3" id="course-title">
    <h2>课程标题(2302910384)</h2>
</div>
<div class="col-md-4 col-md-offset-3" id="course-other-info" style="text-align: right">
    <h4>授课老师：<a href="#">刘二能</a></h4>
</div>
<%--<div class="col-md-4" id="course-marking" style="text-align: right">--%>
<%--    <ul id="pingStar" style="display: flex;font-size: 25px;">--%>
<%--        <li>评分：</li>--%>
<%--        <li rel="1" title="1分"><span class="glyphicon glyphicon-star-empty"></span></li>--%>
<%--        <li rel="2" title="2分"><span class="glyphicon glyphicon-star-empty"></span></li>--%>
<%--        <li rel="3" title="3分"><span class="glyphicon glyphicon-star-empty"></span></li>--%>
<%--        <li rel="4" title="4分"><span class="glyphicon glyphicon-star-empty"></span></li>--%>
<%--        <li rel="5" title="5分"><span class="glyphicon glyphicon-star-empty"></span></li>--%>
<%--        &nbsp;&nbsp;&nbsp;--%>
<%--        <span id="dir"></span>--%>
<%--    </ul>--%>
<%--    <input type="hidden" value="" id="startP">--%>
<%--</div>--%>
<!-- 信息 -->
<div class="col-md-12">
    <div class="widget-box">
        <!-- tab title -->
        <div class="widget-title">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#tab1">课程信息</a></li>
                <li><a data-toggle="tab" href="#tab2">课程实验报告下载</a></li>
                <li><a data-toggle="tab" href="#tab3">课程模拟试卷下载</a></li>
                <li><a data-toggle="tab" href="#tab4">课程大纲下载</a></li>
            </ul>
        </div>
        <!-- tab title -->
        <div class="widget-content tab-content">
            <!-- 课程信息 -->
            <div id="tab1" class="tab-pane active">
                        <pre class="pre-scrollable">
                            <p>课设专业：高校基础课程</p>
                            <p>课程信息：无</p>
                        </pre>
            </div>
            <!-- 课程信息 -->
            <!-- 实验报告 -->
            <div id="tab2" class="tab-pane">
                <div class="widget-box" style="margin-top: 50px">
                    <!-- 上传新的实验 -->
                    <form class="form-horizontal" action="" style="margin-top: 50px">
                        <div class="col-md-12 form-group">
                            <label for="uploadExp" class="control-label col-sm-3">上传课程的新实验报告</label>
                            <div class="col-sm-3">
                                <input id="uploadExp" class="form-control" type="text" name="fileName" placeholder="填写上传实验的名称">
                            </div>
                            <div class="col-sm-3">
                                <input type="file" id="courseOutline" name="expUpload" required>
                                <p class="help-block">*必填</p>
                            </div>
                            <div class="col-sm-3">
                                <input type="submit" class="btn btn-default" value="新的实验">
                            </div>
                        </div>
                    </form>
                    <!-- 上传新的实验 -->
                    <!-- 实验表格 -->
                    <div class="widget-content nopadding">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 1000px">实验报告标题</th>
                                <th style="width: 200px">上传人</th>
                                <th style="width: 200px">下载&nbsp;/&nbsp;删除</th>
                                <th>下载次数</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- 实验表格 -->
                </div>
                <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                    <ul class="pagination">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
            <!-- 实验报告 -->
            <!-- 模拟试卷 -->
            <div id="tab3" class="tab-pane">
                <div class="widget-box">
                    <!-- 上传新的模拟试卷 -->
                    <form class="form-horizontal" action="" style="margin-top: 50px;">
                        <div class="col-md-12 form-group">
                            <label for="uploadExp" class="control-label col-sm-3">上传课程的新模拟试卷</label>
                            <div class="col-sm-3">
                                <input id="uploadPaperTest" class="form-control" type="text" name="fileName" placeholder="填写上传模拟试卷的名称">
                            </div>
                            <div class="col-sm-3">
                                <input type="file" id="paperTest" name="expUpload" required>
                                <p class="help-block">*必填</p>
                            </div>
                            <div class="col-sm-3">
                                <input type="submit" class="btn btn-default" value="新的模拟试卷">
                            </div>
                        </div>
                    </form>
                    <!-- 上传新的模拟试卷 -->
                    <!-- 模拟试卷表格 -->
                    <div class="widget-content nopadding">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 1000px">模拟试卷标题</th>
                                <th style="width: 200px">上传人</th>
                                <th style="width: 200px">下载&nbsp;/&nbsp;删除</th>
                                <th>下载次数</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            <tr class="gradeX">
                                <td>实验内容标题好长好长好长好长好长好长好长好长好长好长好长好长好长好长</td>
                                <td>刘二能</td>
                                <td><a href="#">点这里下载</a> &nbsp;&nbsp; <a href="#">删除</a></td>
                                <td class="center">12</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- 模拟试卷表格 -->
                </div>
                <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                    <ul class="pagination">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>

                </div>
            </div>
            <!-- 模拟试卷 -->
            <!-- 课程大纲 -->
            <div id="tab4" class="tab-pane">
                <div class="widget-box">
                    <div class="widget-content nopadding">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th style="width: 1000px">课程大纲</th>
                                <th style="width: 200px">上传人</th>
                                <th>下载次数</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <td> <a href="#">点这里下载</a></td>
                                <td>刘二能</td>
                                <td class="center">12</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- 课程大纲 -->
        </div>
        <!-- CourseContentMain -->
    </div>
</div>
<!-- 信息 -->