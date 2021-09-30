<template>
  <div class="eisenhower-visualisation-container">
    <EisenhowerVisualisationQuadrants/>
  </div>
</template>

<script>
import EisenhowerVisualisationQuadrants from "@/components/EisenhowerVisualisationQuadrants.vue";
export default {
  name: "EisenhowerVisualisationContainer",
  props: {
    visualisationType: String
  },
  components: {
    EisenhowerVisualisationQuadrants
  }
};
</script>

<!-- No style : a container is only here to manage data fetch and components alimentation -->
<style>
</style>
