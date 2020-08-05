package com.sist.data;

// 데이터 관리
import java.util.*;
import java.io.*;
/*
 *  프로그램 작성( 프로그램들을 조합하는 과정)
 *  = 파일 : 분리할 수 없다 => 전체를 통으로 저장==========> AI
 *       =1. 전체파일을 읽어서 분리 => 메모리에 저장
 *       					   ====== ArrayList 에 저장
 *       	 FileReader
 *           StringTokenizer,split
 *       =2. 메모리에서 제어
 *  = 오라클 : 분리가 되어 있는 상태 
 *    = 필요시마다 오라클에 연결 => 메소드안에서 처리
 */
public class talingManager {

	
	//데이터 저장
		private static ArrayList<talingVO> list=
				new ArrayList<talingVO>();
		//모든 자바파일에서 공통으로 사용해야 하기 때문에 반드시 static으로 선언
		//프로그램 시작할때 => 데이터 수집 => ArrayList에 저장후 시작
		static
		{
			try
			{	
				/*
				 *   파일 읽기 방법 2가지 =>
				 *   1. 한글자씩 읽는 방법 => read()
				 *   	FileInputStream
				 *      FileReader
				 *   2. 한줄씩 읽는 방법 => readline()
				 *      전체 데이터를 임시저장공간에 저장후 사용
				 *   	BufferedReader
				 *   
				 */
				//저장된 파일 읽기*****
				FileInputStream fr=new FileInputStream("c:\\javaDev\\taling_data2.txt");
				//메모리에 전체 데이터를 모아서 관리
				BufferedReader in=new BufferedReader(new InputStreamReader(fr));//버퍼드리더 임시 기억저장장치
				while(true)
				{
					String lesson=in.readLine(); // readLine() => \n줄이 바뀔때까지 읽어옴
					if(lesson==null) break; // 종료 => 파일을 다 읽은 경우
					/*
					 * 1|1|[원데이/투잡/온라인] 운영비 0원으로 월 100만원 추가수입 스마트스토어 쿠팡 오픈마켓 온라인마켓셀러 
					 * 투잡의 모든것|//img.taling.me/Content/Uploads/Profile/e1c33ce7207e7fedf5c8
					 * 1930b3ebfb9ddc946d8b.jpg|￦19,900/시간|온라인|김용빈|3시간/회|스카이프로 진행되는 원데이 
					 * 온라인 클래스입니다 튜터 컴퓨터 화면을 공유하며 진행하는 수업으로 얼굴노출되실 우려가 없습니다. 수업전날 문자로
					 *  튜터의 스카이프 아이디를 공유드립니다 ? 저는 10년차 온라인 MD입니다. 1. 前 롯데닷컴MD 2. 現 유통,
					 *   마케팅, 디자인 컨설팅 에이전시 3. 9년차 온라인 MD, 마케터 4. 네이버 유통과학 연구회 운영자 5. 
					 *   스마트스토어, 쿠팡, 위메프 등 셀러 ? 안녕하세요 김용빈 튜터입니다 ! 마케팅과 트렌드는 POP 처럼 
					 *   재미있게! 온라인 유통,마케팅 컨설팅 에이전시 트렌드팝의 대표 김용빈 이라고 합니다. 저는 2009년 부터
					 *    롯데닷컴 입사를 시작으로 오늘날까지 주로 온라인 MD와 마케터로 경력을 쌓았으며 현재는 유통/마케팅/디자인 
					 *    컨설팅 에이전시 창업을 준비하면서 온라인 마케팅 포털 아이보스와 네이버 유통과학 연구회 카페에서 게시판
					 *     운영자로 운영자로 활동중입니다. 해마다 수십만개 이상의 스마트스토어 계정이 생겨납니다. 그러나 
					 *     만들어진후 거래가 발생하는 비중은 약 53% 1년 이상 유지가 되는 비중은 44% 에 불과합니다. 
					 *     때문에 제 수업에서는 자본과 시간부담없이 스마트스토어 계정을 생성하고 상품을 확보하고 판매하는 
					 *     방법 뿐만아니라 지속가능한 운영방법과 홍보방법에 대해 말씀드리고자 합니다. 재고매입 비용과 광고비
					 *      없이도 스마트스토어 운영이 과연 가능하냐구요? 네 가능합니다 제가 수년간 해온일이 바로 그것이니까요 ^^
					 *       세상에는 여러분을 통해 제품을 판매하고싶어하는 제조사와 상품이 아주아주 많습니다. 재고부담과 시간부담
					 *        없이 직장을 다니면서도 하루 2시간만 꾸준히 투자할수 있는 의지만 있다면 스마트스토어를 통한 
					 *        월 200만원의 부가수입 그리고 그 이상도 
					 */
					
					StringTokenizer st=new StringTokenizer(lesson,"|");
					while(st.hasMoreTokens())
					{
						try {
						talingVO vo=new talingVO();
						vo.setLno(Integer.parseInt(st.nextToken()));
						vo.setCno(Integer.parseInt(st.nextToken()));
						vo.setTitle(st.nextToken());
						vo.setImage("https:"+st.nextToken());
						vo.setPrice(st.nextToken());
						vo.setSpot(st.nextToken());
						vo.setName(st.nextToken());
						vo.setTime(st.nextToken());
						vo.setInfo(st.nextToken());
						
						list.add(vo);
						}catch(Exception ex) {}
					}
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		public ArrayList<talingVO> movieListData(int page)
		{//총페이지 나누는 방법
			ArrayList<talingVO> lessons=new ArrayList<talingVO>();
			int i=0;
			int j=0;
			int pagecnt=(page*10)-10;
			
			/*
			 *     1page  => 0~9
			 *     2page   => 10~19
			 *     3page   => 20~29
			 *     
			 */
			for(talingVO vo:list)
			{
				if(i<10 && j>=pagecnt)
				{
					lessons.add(vo);
					i++;
				}
				j++;
			}
			return lessons;
			
		}
		public int lessonTotalPage()
		{
			return (int)(Math.ceil(list.size()/10.0));
			//ceil는 올림 메소드
		}
		//상세보기
		public talingVO talingDetailData(int mno)
		{
			return list.get(mno-1);//get에 들어가는건 인댁스번호라서 0번부터 시작
		}
		//영화전체읽기
		public ArrayList<talingVO> talingAllData(int cno)
		{
			ArrayList<talingVO> movies=new ArrayList<talingVO>();
			for(talingVO vo:list)
			{
				if(vo.getCno()==cno)
				{
					movies.add(vo);
				}
			}
			return movies;
		}
		//무비검색
		public ArrayList<talingVO> movieFindData(String ss)
		{//Arraylist는 몇개가 검색되도 유동적으로 대응이 가능하지만 배열은 갯수를 정해놔서 한계가 있다
			ArrayList<talingVO> movies=new ArrayList<talingVO>();//가변형인 배열
			//list
			for(talingVO vo:list)
			{
				if(vo.getTitle().contains(ss))
				{
					movies.add(vo);
				}
			}
			
			return movies;
		}
		public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			System.out.print("페이지:");
			int page=scan.nextInt();
			
			talingManager m=new talingManager();
			System.out.println(page+" page / "+m.lessonTotalPage()+" pages");
			
			//데이터 읽기
			ArrayList<talingVO> list=m.movieListData(page);
			
			for(talingVO vo:list)
			{
				System.out.println(vo.getInfo());
			}
			/*
			 * for(MovieVO vo:list) { if(vo.getTitle().contains(ss))
			 * {System.out.println(vo.getTitle()); } }
			 */
		}
	}
