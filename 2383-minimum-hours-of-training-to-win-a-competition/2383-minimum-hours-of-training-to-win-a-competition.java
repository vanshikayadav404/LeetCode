class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience,
                                int[] energy, int[] experience) {

        int totalEnergy = 0;
        int energyHours = 0;

        for (int i = 0; i < energy.length; i++) {
            totalEnergy += energy[i];
        }

        if (initialEnergy <= totalEnergy) {
            energyHours = (totalEnergy + 1) - initialEnergy;
        }

        int exp = initialExperience;

        for (int i = 0; i < experience.length; i++) {

            if (exp <= experience[i]) {
                int expHours = (experience[i] + 1) - exp;

                energyHours += expHours;
                exp += expHours;
            }

            exp += experience[i];
        }

        return energyHours;
    }
}