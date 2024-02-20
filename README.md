# 2024_SolutionChallenge_EmergencyMate

## 🎯 Introduction
한국의 대학 병원에서 환자가 장시간 대기 중 심정지로 인해 사망하는 사건이 일어났다. 병원에서는 대기 중인 환자가 잠을 자는 줄 알고 그대로 방치했다고 한다. 복잡한 병원에서는 장시간 대기 중인 환자를 관리하는 것이 어렵다는 것을 보여주는 사례이며, 이는 최악의 경우 환자의 사망으로 이어질 수 있는 매우 심각한 문제이다. 병원 측에서는 이를 해결하기 위해 간호 인력 상시 배치 및 CCTV 증설 및 모니터링 강화를 방안으로 내놓았다. 하지만 간호 인력 상시 배치는 현재도 부족한 간호 인력의 비효율적인 활용을 가져오며, CCTV 모니터링으로는 심정지 환자를 실제적으로 감지해내기 어렵다는 문제가 있다. EmergencyMate는 호출벨 기능을 활용해 환자가 정말로 도움이 필요한 순간을 감지해낼 수 있어, 해당 순간에 간호 인력을 집중시킴으로써 효율적인 간호인력 활용 및 환자 케어가 가능해진다. 또한 아두이노 장치를 활용해 실제 심박수를 체크하고 문제 시 즉각적인 호출로 실질적으로 문제를 해결한다.

## 🛠 Architecture
![architecture](https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/d1ec5fd8-d7fb-46a7-9e19-a9660e269b45)

## 📽 Demo Video
<a href="https://github.com/leaf1191">![youtube](https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/65040981-53b2-4bac-8212-c41469ac1d50)

## ❓️ How to use?
### Login
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7b0c3ec1-3242-4e9f-b710-fa907b72b8d7" width = 300 height = 600>

가운데 로그인 버튼으로 구글 소셜로그인이 가능하다.

### Select
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/e4ed2709-6cf9-48f6-bcec-bea47e0c0396" width = 300 height = 600>

역할 유형을 선택한다. 환자를 선택하면 환자페이지로 관리자를 선택하면 관리자 페이지로 이동한다. 한 번 선택하면 로그아웃 전까지는 되돌릴 수 없다.

### Patient Page
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/fb29bc23-069a-47ea-8235-330d925edd67" width = 300 height = 600>

환자 메인 페이지로 로그아웃 및 다양한 페이지로의 이동을 지원한다. 다음은 환자페이지의 주요 기능들이다.

#### Heart Beat
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/dd55fb5d-c80b-4005-97fb-a3c26fd0b140" width = 300 height = 600>

심박수 측정 페이지다. 하단의 블루투스 버튼을 눌러 블루투스 장치와 연동할 수 있다. 성공적으로 연동되면 실시간으로 심박수를 감지하며 문제시 등록이 되었다면 관리자를 호출한다. 호출 시 경고음이 울린다.

#### Wait Info
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7990f916-7653-4b4e-bb66-49a608a1aace" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/272bc88a-ed63-450e-a1a9-1e0c77ae1652" width = 300 height = 600>

대기 정보 확인 페이지다. 미등록시 좌측화면이 등록시 우측화면이 나오며 입력 정보 및 대기번호를 확인할 수가 있다.

#### Call Bell
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/a2db6911-e27d-47a6-bbfd-588c516f4ff5" width = 300 height = 600>

호출벨이다. 호기심, 혹은 실수로 눌러 혼란을 야기하는 것을 방지하기 위해 3초간 눌러야 작동하도록 설계하였다. 역시 등록이 되어야 호출한다. 호출 시 경고음이 울린다.

#### When Admin Call
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/d606ac86-6adf-41ff-bbff-64c0510e0432" width = 300 height = 600>

관리자가 환자를 호출했을 때 이동하는 화면이다. 환자쪽에서는 자체적으로 이동하는 것이 불가능하고 로그아웃만이 가능하다. 로그아웃시 관리자 목록에서 삭제되며, 환자의 차례가 되었음을 알려 원활한 업무 진행을 돕는다.

### Admin Page
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/b0dcbe73-e938-427c-a855-00820565355e" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/1aa23e99-f777-4f6f-bfaa-d23af394a3f9" width = 300 height = 600>

관리자 화면이다. 로그아웃 버튼과 더불어 등록된 환자를 grid 방식으로 확인할 수 있으며, 환자의 차례를 알리는 호출, grid에서의 삭제를 할 수 있다. 환자 칸을 누르면 등록된 정보를 확인할 수 있다. 상단의 추가를 누르면 미등록 환자를 등록할 수 있다.

#### Patient Register
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/1d062760-3bae-4d51-8e17-eb1485f22314" width = 300 height = 600>

<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/4af9ad0e-29b0-4c4c-b0c8-7206b240160e" width = 300 height = 600>

미등록 환자 추가 화면이다. 리스트의 칸을 눌러 작성페이지로 이동하며 작성페이지에서 상세정보를 등록한다. 성공적으로 등록되면 메인 화면 grid에 추가된다.

#### When Patient Call
<img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/c009af5f-df10-4017-b63b-e8eade903d28" width = 300 height = 600>

환자가 호출을 했을 때 변하는 화면이다. 환자 한명이라도 호출이 들어왔을 시 경고음이 울리며 환자 확인을 통해 호출 상황을 종료할 수 있다.

## 💡 Contributors
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7ae8661c-e289-4957-a7fc-022cca93c930" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/146098855/ede0a4d1-da68-441c-92a1-006035ba1e32" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/104562082/76af99bd-04d1-4267-955a-f2a505909876" width = 200 height = 200>
      <td align="center" valign="top" width="200"><img src = "https://github.com/leaf1191/2024_SolutionChallenge_EmergencyMate/assets/136419794/7ae8661c-e289-4957-a7fc-022cca93c930" width = 200 height = 200>  
    </tr>
    <tr>
      <td align="center" valign="top" width="200"><a href="https://github.com/leaf1191"><sub><b>심종우</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/zhyunn"><sub><b>김지현</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/Hyerim20"><sub><b>강혜림</b></sub>
      <td align="center" valign="top" width="200"><a href="https://github.com/Hyerim20"><sub><b>링크도 수정</b></sub>  
    </tr>
    <tr>
      <td align="center" valign="top" width="200"><sub><b>Flutter, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>Spring, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>Spring, Firebase</b></sub>
      <td align="center" valign="top" width="200"><sub><b>내용적기</b></sub> 
    </tr>
  </tbody>
</table>
