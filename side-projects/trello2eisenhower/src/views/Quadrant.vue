<template>
  <div class="home">
    <EisenhowerVisualisationContainer visualisationType="quadrant"/>
  </div>
</template>

<script>
// @ is an alias to /src
import EisenhowerVisualisationContainer from "@/components/EisenhowerVisualisationContainer.vue";

export default {
  name: "quadrant",
  components: {
    EisenhowerVisualisationContainer
  }
};
</script>
