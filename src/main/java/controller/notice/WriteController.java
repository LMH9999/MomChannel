package controller.notice;

import dao.NoticeDAO;
import dao.QNABoardDAO;
import utils.JSFunction;
import vo.MemberVO;
import vo.NoticeVO;
import vo.QNABoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException; 


@WebServlet("/view/cs/notice/write.do")
public class WriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("./Write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MemberVO mvo= new MemberVO();
        HttpSession session = req.getSession();
        mvo = (MemberVO) session.getAttribute("loginMember");
        System.out.println(mvo);

        // 2. 파일 업로드 외 처리 =============================
        // 폼값을 DTO에 저장
        NoticeVO vo = new NoticeVO();
        vo.setNoticeCategory(req.getParameter("noticeCategory"));
        vo.setNoticeTitle(req.getParameter("noticeTitle"));
        vo.setNoticeContent(req.getParameter("noticeContent"));

        // DAO를 통해 DB에 게시 내용 저장
        NoticeDAO dao = new NoticeDAO();
        int result = dao.insertWrite(vo);

        // 성공 or 실패?
        if (result == 1) {  // 글쓰기 성공
            resp.sendRedirect("./list.do");
        }
        else {  // 글쓰기 실패
            JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.",
                    "./write.do");
        }
    }
}