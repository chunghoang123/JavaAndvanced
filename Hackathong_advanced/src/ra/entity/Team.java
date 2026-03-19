package ra.entity;

import java.util.Scanner;

public class Team {
    private String teamId;
    private String teamName;
    private int memberCount;
    private double averageWeight;

    public Team() {}

    public Team(String teamId, String teamName, int memberCount, double averageWeight) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.averageWeight = averageWeight;
    }

    public String getTeamId() { return teamId; }
    public String getTeamName() { return teamName; }
    public int getMemberCount() { return memberCount; }
    public double getAverageWeight() { return averageWeight; }

    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setMemberCount(int memberCount) { this.memberCount = memberCount; }
    public void setAverageWeight(double averageWeight) { this.averageWeight = averageWeight; }

    public void inputData(Scanner sc) {
        // ID format T001
        while (true) {
            System.out.print("Nhập mã đội (Txxx): ");
            String id = sc.nextLine();
            if (id.matches("T\\d{3}")) {
                this.teamId = id;
                break;
            } else {
                System.out.println("Sai định dạng!");
            }
        }

        System.out.print("Nhập tên đội: ");
        this.teamName = sc.nextLine();

        while (true) {
            try {
                System.out.print("Số thành viên (>=10): ");
                int m = Integer.parseInt(sc.nextLine());
                if (m >= 10) {
                    this.memberCount = m;
                    break;
                }
                System.out.println("Phải >= 10!");
            } catch (Exception e) {
                System.out.println("Nhập sai!");
            }
        }

        while (true) {
            try {
                System.out.print("Cân nặng TB: ");
                this.averageWeight = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai!");
            }
        }
    }

    public void displayData() {
        System.out.printf("| %-5s | %-20s | %-5d | %-8.2f |\n",
                teamId, teamName, memberCount, averageWeight);
    }
}